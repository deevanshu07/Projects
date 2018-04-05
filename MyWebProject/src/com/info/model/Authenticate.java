package com.info.model;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/secure")
public class Authenticate {

	@GET
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	
	public String securedMethod() {
		System.out.println("Welcome user");
		return "Welcome user";
	}

}
