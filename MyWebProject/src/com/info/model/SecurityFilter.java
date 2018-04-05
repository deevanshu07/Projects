package com.info.model;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URL_PREFIX = "secure";

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)){
		List<String> authHeader = requestContext.getHeaders().get(
				AUTHORIZATION_HEADER_KEY);
		System.out.println("Security filter");
		if (authHeader!=null && authHeader.size() > 0) {
			String authToken = authHeader.get(0);
			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX,
					"");
			System.out.println("Authtoken="+authToken);
			String decodeString = Base64.decodeAsString(authToken);
			System.out.println(decodeString);
			StringTokenizer tokenizer = new StringTokenizer(decodeString, ":");
			String userName = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			System.out.println(userName);
			System.out.println(password);

			if ("user".equals(userName) && "password".equals(password))
				return;
		}

		Response unauthorizedAccess = Response
				.status(Response.Status.UNAUTHORIZED)
				.entity("Can not access this resource").build();

		requestContext.abortWith(unauthorizedAccess);

	}
	}
}
