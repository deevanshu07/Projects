package com.info.model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.info.authenticate.Employee;

// Plain old Java Object it does not extend as class or implements
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation.
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML.

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/")
public class User {

	Employee emp;

	// This method is called if TEXT_PLAIN is request
	@Path("/xml")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Employee sayPlainTextHello() {
		emp = new Employee(101, "Deevanshu");
		System.out.println("Application xml");
		System.out.println(emp);
		return emp;
	}

	@Path("/add")
	@POST
	public Response addTwoNumbers(@FormParam("number1") int number1,
			@FormParam("number2") int number2) {

		int result = number1 + number2;
		System.out.println("Post request in adding numbers");
		List<String> list = new ArrayList<String>();
		list.add("POST");
		list.add("GET");
		list.add("PUT");
		list.add("DELETE");
		return Response.status(200)
				.entity("The addition of two numners is " + list).build();
	}

	@Path("/params/")
	@GET
	public Response pathParams(@QueryParam("from") String from,
			@QueryParam("to") String to,
			@QueryParam("orderBy") List<String> orderBy) {

		System.out.println("from=" + from);
		System.out.println("to=" + to);
		System.out.println("OrderBy=" + orderBy);

		return Response.status(200)
				.entity("Valid Params " + from + " " + to + " " + orderBy)
				.build();
	}

}
