/**
 * @Classname TWCRoleBasedUser
 * Date May 03 2017
 */
package com.twc.authenticator;

import java.security.Permissions;
import java.security.Principal;
import java.util.Set;

import org.apache.log4j.Logger;

import com.inquira.infra.security.impl.RoleBasedUser;

/**
 * This class is used by TWCAuthenticator class for creating the user session in OKM.
 * This is the extended class of RoleBasedUser and implementing constructors
 * 
 * @author Rakesh.Dadwal
 * 
 */
public class TWCRoleBasedUser extends RoleBasedUser {

	private static Logger logger = Logger.getLogger(TWCRoleBasedUser.class);

	/**
	 * Constructor
	 * 
	 * @param userId
	 *            String object
	 * @param domain
	 *            String object
	 * @param displayName
	 *            String object
	 * @param principal
	 *            Principal object
	 * @param roles
	 *            Set object
	 * @param permissions
	 *            Permissions object
	 * @param timestamp
	 *            datetime
	 */
	public TWCRoleBasedUser(String userId, String domain,String displayName, Principal principal, Set roles,Permissions permissions, long timestamp, String emailAddress) {
		super(userId, domain, displayName, principal, roles, permissions,timestamp);
		//logger.debug("In TWCRoleBasedUser userId :" + userId + ": domain :" + domain + ": diplayName :" + displayName	+ ": roles :" + roles + ": timestamp :" + timestamp	+ ": emailAddress :" + emailAddress);
		// Override loginId value
		this.loginId = userId;
		this.emailAddress = emailAddress;
	}

}
