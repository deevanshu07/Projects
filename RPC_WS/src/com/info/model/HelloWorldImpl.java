package com.info.model;

import javax.jws.WebService;



@WebService(endpointInterface = "com.info.model.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String getHelloWorldAsString(String name) {
		// TODO Auto-generated method stub
		return "Hello World JAX-WS " + name;
	}

}
