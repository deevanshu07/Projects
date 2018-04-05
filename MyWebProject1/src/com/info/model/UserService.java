package com.info.model;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
@Path("/UserService")
public class UserService implements UserInterface {

	UserDao dao;
	public UserService(){
		dao=new UserDao();
	}
	
	@GET
	@Path("/users")
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> getAllUsers() {
		System.out.println("In side");
		return dao.getAllUsers();
		
	}

}
