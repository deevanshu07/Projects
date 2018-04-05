package com.info.authenticate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



public class BasicAuthentication {
	
	@GET
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	public String securedMethod(){
		return "Welcome user";
	}
}
