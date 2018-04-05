/**
 * @Classname TWCAuthenticator
 * Date May 03 2017
 */
package com.twc.authenticator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.Permissions;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.InvalidSearchFilterException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.apache.log4j.Logger;

import com.inquira.infra.IUser;
import com.inquira.infra.security.Field;
import com.inquira.infra.security.FieldValue;
import com.inquira.infra.security.IAuthenticator;
import com.inquira.infra.security.IFieldNames;
import com.inquira.infra.security.InputField;
import com.inquira.infra.security.InquiraAuthenticationException;
import com.inquira.infra.security.OKEncryptionException;
import com.inquira.infra.security.OKResourceEncryption;
import com.inquira.infra.security.StandardPermission;
import com.inquira.util.security.SimplePrincipal;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPException;
import com.novell.ldap.LDAPJSSESecureSocketFactory;

/** 
 * TWCAuthenticator implementation class IAuthenticator
 * This class will be used as custom authenticator, TWCAuthenticator implementation class IAuthenticator * 
 * This class is the entry point for authentication into Infocenter and IM. it will get the userid/guid from the request header and validate it accordingly.
 * @author Rakesh.Dadwal
 */

public class TWCAuthenticator implements IAuthenticator, IFieldNames {

	private static Logger logger = Logger.getLogger(TWCAuthenticator.class);

	/*
	 *  override method
	 * @see com.inquira.infra.security.IAuthenticator#getAuthenticationFields()
	 */
	public Field[] getAuthenticationFields()
			throws InquiraAuthenticationException {
		// this authenticator requires a username, password, and repository to
		// authenticate.
		return new Field[] { new InputField(FIELD_USER_ID),
				new InputField(FIELD_PASSWORD, true),
				new InputField(FIELD_DOMAIN) };
	}

	/*
	 * override method
	 * @see com.inquira.infra.security.IAuthenticator#getDomain()
	*/
	public String getDomain() {
		return "TWC"; // Work for other domain/repository as we are passing the domain/repo from property file
	}

	/* 
	 * Override method IAuthenticator is implementing the actual authentication and authorization logic
	 * Login credentials are provided to the InfoManager or InfoCenter application, either from the login page fields, or from http request headers when Single Sign On is used.
	 * These credentials are delegated to the Inquira Authenticator. This is not the IAuthenticator yet, but the non-customizable authentication class within the application.
	 * The InquiraAuthenticator will call the authenticate() method of this custom authenticator class. This method takes three parameters:
		� The first parameter is an array of com.inquira.infra.security.FieldValue objects. A FieldValue is essentially a key-value pair. The array passes the provided username, password, repository name for which the login was attempted, plus all http request headers of the login attempt (very nice!). The last part opens up possibilities for Single Sign On customization or other neat things of the sort.
		� The second parameter is a java.util.Map object, which in Oracle documentation is referred to as the roles2PermissionsMap. This Map contains all Role, View and Group reference keys that are defined in the repository for which a login is attempted. Roles are prefixed with R_, views with V_ and groups with G_. For example, if your repository contains a role with reference key TEST_ROLE, the roles2PermissionsMap will contain an entry by the name of R_TEST_ROLE.
		� The third parameter is a long integer type timestamp of the login attempt.
	 * The authenticate() method performs its magic. Purpose of this code is to figure out if provided credentials are correct and what roles, views and groups your user is a member of in the external authentication store. If no user can be authenticated, a com.inquira.infra.security.InquiraAuthenticationException can be thrown to notify the InquiraAuthenticator of this fact.
     * The authenticate() method returns an object of class com.inquira.infra.security.impl.RoleBasedUser (implements com.inquira.infra.IUser interface). The RoleBasedUser contains a number of properties like loginname, first name, last name, email address, roles, views and groups of the authenticated user.
	 * The RoleBasedUser object is picked up by the InquiraAuthenticator, which will read its properties, verify permissions and update the USERINFORMATION table in your IM database schema with the new information. From here the normal OKM IM authentication process takes over again.
	 */

	public synchronized IUser authenticate(FieldValue[] fieldValueArray,	Map roles2PermissionsMap, long timestamp) throws InquiraAuthenticationException {

		//logger.debug("Inside custom authenticate()");
		
		IUser user = null;
		String imHome = System.getProperty("IM_HOME");
		File fileProperties = new File(imHome, "config/TWC/ldap.properties");
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(fileProperties));
		} catch (FileNotFoundException e2) {
			logger.error("InFile not found exception from filepath "+ fileProperties);
			e2.printStackTrace();
			return null;
		} catch (Exception e2) {
			logger.error("Exception from filepath " + fileProperties);
			e2.printStackTrace();
			return null;
		}

		String ldapHost = checkNull(properties.getProperty("LDAP_HOST"));
		String ldapPort = checkNull(properties.getProperty("LDAP_PORT"));
		String ldapURL = checkNull(properties.getProperty("LDAP_URL"));

		String ldapUserDomain = checkNull(properties.getProperty("LDAP_USER_DOMAIN"));
		String ldapUserDN = checkNull(properties.getProperty("LDAP_USER_DN"));
		String ldapPassword = checkNull(properties.getProperty("LDAP_PASSWORD"));
		//String displayNameMapKey = checkNull(properties.getProperty("DISPLAY_NAME_MAP_KEY"));
		String roleViewMapKey = checkNull(properties.getProperty("ROLE_VIEW_MAP_KEY"));
		String firstNameMapKey = checkNull(properties.getProperty("FIRST_NAME_MAP_KEY"));
		String lastNameMapKey = checkNull(properties.getProperty("LAST_NAME_MAP_KEY"));
		String emailMapExchKey = checkNull(properties.getProperty("EMAIL_MAP_EXCH_KEY"));
		String emailMapMailKey = checkNull(properties.getProperty("EMAIL_MAP_MAIL_KEY"));
		String userNameMapKey = checkNull(properties.getProperty("USERNAME_MAP_KEY"));
		String userSearchBase = checkNull(properties.getProperty("USER_SEARCH_BASE_TWCOU"));
		String roleViewSearchBase = checkNull(properties.getProperty("ROLE_VIEW_SEARCH_BASE"));
		String roleViewDNMapKey = checkNull(properties.getProperty("ROLE_VIEW_DN_MAP_KEY"));
		String roleViewDescMapKey = checkNull(properties.getProperty("ROLE_VIEW_DESC_MAP_KEY"));
		String repository = checkNull(properties.getProperty("REPOSITORY")); /*Domain*/

		//String firstName = "",lastName = "", email = "", displayName = "";
		String firstName = "",lastName = "", email = "";
		
		Set<String> viewRolesPrefix = new HashSet<String>();

		String username = getFieldValue("username", fieldValueArray);
		String user_id = getFieldValue("USER_ID", fieldValueArray);
		String password = getFieldValue("PASSWORD", fieldValueArray);
		System.out.println("Dev Test Username -- >"+username);
		System.out.println("Dev Test user_id -- >"+user_id);
		if ((username == null || username.equals("")) && user_id != null && !user_id.equals("") && password != null	&& !password.equals("")) {
			// code for authenticating through LDAPBind for AnswerFlowEditor/IMWS client
			logger.debug("Authenticating through LDAPBind method...");
			//synch
			boolean authResult = authenticateUserByBind(ldapHost,Integer.parseInt(ldapPort),ldapUserDomain + "\\" + user_id, password);
			if (authResult)
				username = user_id;
			else
				logger.debug("binding failed");
		}

		logger.debug("username " + username);
		System.out.println("username " + username);
		if (username!=null && username.equals("")){
		if(username.toUpperCase().contains("SVC-EKM")){ // Checking service account user
			userSearchBase = checkNull(properties.getProperty("USER_SEARCH_BASE_SAOU"));
			System.out.println("Checking for null");
		}
	}
		// code for decrypting passwords

		try {
			ldapPassword = OKResourceEncryption.decryptResource(ldapPassword);			
		} catch (OKEncryptionException e) {
			logger.error("Exception while decrypting the LDAP password "+ e.getMessage());
			System.out.println("OKM ENCRYPTION EXCEPTION="+e.getMessage());
		}

		// code for LDAP user search
		try {
			DirContext dirContext = null;
			try {

				Hashtable envDetails = new Hashtable(11);
				envDetails.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
				envDetails.put(Context.PROVIDER_URL, ldapURL);
				envDetails.put(Context.SECURITY_PROTOCOL, "ssl");
				envDetails.put(Context.SECURITY_AUTHENTICATION, "simple");
				envDetails.put(Context.SECURITY_PRINCIPAL, ldapUserDN);
				envDetails.put(Context.SECURITY_CREDENTIALS, ldapPassword);
				dirContext = new InitialDirContext(envDetails);

				logger.debug("Connected to " + ldapURL);
				System.out.println("Connected to LdapURL"+ldapURL);
				SearchControls searchCtls = new SearchControls();
				searchCtls.setSearchScope(2);
				//String[] returnedAtts = { displayNameMapKey, roleViewMapKey, firstNameMapKey, lastNameMapKey, emailMapExchKey,emailMapMailKey };
				String[] returnedAtts = { roleViewMapKey, firstNameMapKey, lastNameMapKey, emailMapExchKey,emailMapMailKey };
				searchCtls.setReturningAttributes(returnedAtts);
				String searchFilter = "(" + userNameMapKey + "=" + username	+ ")";
				String searchBase = userSearchBase;
				NamingEnumeration extraNE = dirContext.search(searchBase, searchFilter, searchCtls);

				while (extraNE.hasMore()) {
					SearchResult searchResult = (SearchResult) extraNE.next();
					Attributes attrs = searchResult.getAttributes();
					try {
						//displayName = (String) attrs.get(displayNameMapKey).get();
						//logger.debug("displayName " + displayName);
											
						email = attrs.get(emailMapExchKey) !=null ? (String) attrs.get(emailMapExchKey).get():""; // fetched from AD msExchExtensionAttribute31 attribute
						logger.debug("Email from msExchExtensionAttribute31:"+ email);
						System.out.println("Email from msExchExtensionAttribute31:"+ email);

						// Added the logic as per OKM-1071
						if (email == null || "".equals(email.trim())) {
							email = attrs.get(emailMapMailKey) !=null ? (String) attrs.get(emailMapMailKey).get():""; // fetched from AD mail attribute
							logger.debug("Email from mail:" + email);
							System.out.println("Email from mail:" + email);
						}

						if (email == null || "".equals(email.trim())) {
							email = username + "@no.op";
							logger.debug("Email set by custom auth:" + email); // setting dummy email
							System.out.println("Email set by custom auth:" + email); // setting dummy email
						}
						
						firstName = attrs.get(firstNameMapKey) !=null ? (String) attrs.get(firstNameMapKey).get():username;
						lastName = attrs.get(lastNameMapKey) !=null ? (String) attrs.get(lastNameMapKey).get():username;

					} catch (NullPointerException e) {
						logger.error("NullPointer exception while fetching user attributes "+ e);
						System.out.println("NullPointer exception while fetching user attributes "+ e);
					}

					try {
						Attribute memberOfA = attrs.get(roleViewMapKey);
						String memberOf = "";
						// Fetching all groups
						if (memberOfA != null) {
							for (Enumeration eNum = memberOfA.getAll(); eNum.hasMoreElements();) {

								String unprocessedGroupDN = eNum.nextElement().toString();
								logger.debug("AD CN Group:memberOf:" + unprocessedGroupDN);
								memberOf = unprocessedGroupDN;
								searchBase = roleViewSearchBase;
								searchFilter = "(" + roleViewDNMapKey + "="	+ memberOf + ")";
								searchCtls = new SearchControls();
								searchCtls.setSearchScope(2);

								String[] returnedAttsRV = { roleViewDescMapKey };
								searchCtls.setReturningAttributes(returnedAttsRV);

								NamingEnumeration extraNErv = dirContext.search(searchBase, searchFilter,searchCtls);
								// Searching roles, views and reporting groups from all fetched groups
								while (extraNErv.hasMore()) {

									SearchResult srRV = (SearchResult) extraNErv.next();
									Attributes attrsRV = srRV.getAttributes();
									try {
										if (attrsRV.get(roleViewDescMapKey) != null) {
											String roleView = (String) attrsRV.get(roleViewDescMapKey).get();
											logger.debug("AD Group Description:"+ roleView);
											viewRolesPrefix.add("V_" + roleView); // Views
											viewRolesPrefix.add("R_" + roleView); // Role
											viewRolesPrefix.add("G_" + roleView); // Reporting Group
										}
									} catch (NullPointerException e) {
										logger.error("Nullpointer exception while fetching roles and views "+ e);
										System.out.println("Nullpointer exception while fetching roles and views "+ e);
									}
								}
							}
						} // end of role/view/reporting groups

						Permissions permissions = new Permissions();
						permissions.add(new StandardPermission("none"));

						// Creating Rolebased user object for InquiraAuthenticator
						try {
							user = new TWCRoleBasedUser(username, repository,firstName + " " + lastName, new SimplePrincipal(username),viewRolesPrefix, permissions, timestamp,email);
							logger.debug(username+"- authenticated successfully");
							System.out.println(username+"- authenticated successfully");
						} catch (Exception e) {
							logger.error(" exception while creating rolebased user"+ e);
							System.out.println(" exception while creating rolebased user"+ e);
						}

					} catch (NullPointerException e) {
						logger.error("NullPointer exception while fetching memberOf attribute "	+ e);
						System.out.println("NullPointer exception while fetching memberOf attribute "	+ e);
					}
				}

			} catch (InvalidSearchFilterException e) {
				logger.error(username + ":User not found in domain." + e);
				System.out.println(username + ":User not found in domain." + e);
			} finally {
				dirContext.close();
				logger.debug("Closing AUTH Connection"); // end of custom auth
				System.out.println("Closing AUTH Connection"); // end of custom auth
			}

		} catch (AuthenticationException e) {
			logger.error(":Could not bind to LDAP server (Invalid username or password). "+ e);
			System.out.println(":Could not bind to LDAP server (Invalid username or password). "+ e);
		} catch (NamingException e) {
			logger.error(":Could not connect to LDAP server. Naming exception "	+ e);
			System.out.println(":Could not connect to LDAP server. Naming exception "	+ e);
		}
		return user;
	}
	
	/*
	 * Method for getting the field value
	 * @param field name - username, domain
	 * @param FieldValue[]
	 * @return String
	 */	
	private String getFieldValue(String fieldName, FieldValue[] userInfo) {
		String fieldValue = null;
		if (userInfo != null) {
			for (int counter = 0; counter < userInfo.length; counter++) {
				FieldValue f = userInfo[counter];
				//logger.debug("Field  " + f.getName() + "  : " + f.getValue());
				if (f.getName().equals(fieldName) == true) {
					fieldValue = f.getValue();
					break;
				}
			}
		}
		return fieldValue;
	}	

	/*
	 * Method for binding the user directly
	 * @param ldap host
	 * @param ldap port
	 * @param userdn
	 * @param password
	 */
	public boolean authenticateUserByBind(String host, int port, String userdn, String password) {
		LDAPConnection userConn = null;
		System.out.println("LDAP Connection");
		userConn = new LDAPConnection(10000);
		if(port == 636 || port == 3269){
			LDAPJSSESecureSocketFactory ldapSecureSocketFactory = new LDAPJSSESecureSocketFactory(); // SSL port 636 case
			System.out.println("LDAP SECURE SOCKET");
			userConn.setSocketFactory(ldapSecureSocketFactory);
		}	
		if (userConn != null) {
			try {
				userConn.connect(host, port);
				System.out.println("Connection successful");
				//logger.debug((new StringBuilder()).append("About to authenticateUserByBind with userdn: ").append(userdn).append(" and password: [hidden]").toString());
				userConn.bind(LDAPConnection.LDAP_V3, userdn, password.getBytes("UTF8"));
				System.out.println("Bind successful");
				//logger.debug("authenticateUserByBind result:"+userConn.isBound());
				return userConn.isBound();
			} catch (Throwable e) {
				logger.error("authenticateUserByBind, Error while connecting with LDAP-"+ userdn+ ":"+e);
				System.out.println("authenticateUserByBind, Error while connecting with LDAP-"+ userdn+ ":"+e);
			} finally {
				if (userConn != null) {
					try {
						userConn.disconnect();
					} catch (LDAPException e) {
						logger.error("An error occurred while disconnecting the LDAP:"+ e);
						System.out.println("An error occurred while disconnecting the LDAP:"+ e);
					}
				}
			}
		}
		return false;
	}

	/*
	 * Method for checking the null value
	 * @param String
	 * @return blank string in case of null
	 */
	public String checkNull(String propValue) {
		if (propValue == null)
			return "";
		else
			return propValue;
	}
}