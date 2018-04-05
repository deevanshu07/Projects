package com.inquira.pmeditor.controller.adf.backing;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.AuthenticationException;

import com.inquira.pmeditor.controller.RepositoryRetriever;
import com.inquira.pmeditor.security.UsernamePasswordRepositoryAuthenticationFilter;
import com.inquira.pmeditor.util.AdfUtil;

@Named
@Scope("request")
public class LoginADFController {
	private String username;
	private String password;
	private String repository;
	private String errorMessageCode;
	private List<SelectItem> repositorySelectItems;

	@Inject
	private RepositoryRetriever repositoryRetriever;

	@Inject
	private UsernamePasswordRepositoryAuthenticationFilter authenticationFilter;

	public void login() {
		try {
			this.authenticationFilter.doFilter(new HttpServletRequestWrapper(
					(HttpServletRequest) FacesContext.getCurrentInstance()
							.getExternalContext().getRequest()) {
				
				public String getRequestURI() {
					//Added by Deevanshu
					System.out.println("UserName 1st>>"+LoginADFController.this.authenticationFilter.getUsernameParameter());
					System.out.println("Password 1st>>>>"+LoginADFController.this.authenticationFilter.getPasswordParameter());
					return getContextPath()
							+ LoginADFController.this.authenticationFilter
									.getFilterProcessesUrl();
				}

				public String getParameter(String name) {
					System.out.println("UserName 2nd===="+LoginADFController.this.username);
					System.out.println("Password 2nd===="+LoginADFController.this.password);
					return "repository".equals(name) ? LoginADFController.this.repository
							: "j_password".equals(name) ? LoginADFController.this.password
									: "j_username".equals(name) ? LoginADFController.this.username
											: null;
				}
			}, new HttpServletResponseWrapper(
					(HttpServletResponse) FacesContext.getCurrentInstance()
							.getExternalContext().getResponse()) {
				public void sendRedirect(String location) throws IOException {
					System.out.println("Adfutil Parameter>>>+"+AdfUtil.getRequestParameter(username));
					System.out.println();
					AdfUtil.redirect(location);
				}
			}, new FilterChain() {
				public void doFilter(ServletRequest request,
						ServletResponse response) {
				}

			});
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ServletException e) {
			throw new RuntimeException(e);
		}
	}

	@PostConstruct
	void initializeForRequest() {
		this.repositorySelectItems = this.repositoryRetriever
				.getRepositorySelectItems();
	}

	void initializeForPageFlow() {
		this.username = AdfUtil.getRequestParameter("username");
		System.out.println("UserName 3rd>>"+AdfUtil.getRequestParameter("username"));

		String repositoryParameter = AdfUtil.getRequestParameter("repository");
		System.out.println("Repository 3rd>>>"+AdfUtil.getRequestParameter("repository"));
		
		if (repositoryParameter != null) {
			this.repository = repositoryParameter;
		} else if (this.repositorySelectItems.size() == 1) {
			this.repository = ((String) ((SelectItem) this.repositorySelectItems
					.get(0)).getValue());
		}
		if (AdfUtil.requestParameterExists("loginError")) {
			Map sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			AuthenticationException authenticationException = (AuthenticationException) sessionMap
					.get("SPRING_SECURITY_LAST_EXCEPTION");
			this.errorMessageCode = (authenticationException != null ? authenticationException
					.getMessage() : "unknown.error");
		}
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepository() {
		return this.repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	public String getErrorMessageCode() {
		return this.errorMessageCode;
	}

	public List<SelectItem> getRepositorySelectItems() {
		return this.repositorySelectItems;
	}
}