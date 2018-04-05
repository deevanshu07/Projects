package com.info.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

	private static final Logger logger = LoggerFactory
			.getLogger(HelloWorldService.class);

	public String getDesc() {
		logger.debug("getDesc() is executed");
		return "Spring Hello World Example";
	}

	public String getTitle(String name) {
		System.out.println("getTitle() is executed and $name=" + name);
		return "Hello "+name;

	}

}
