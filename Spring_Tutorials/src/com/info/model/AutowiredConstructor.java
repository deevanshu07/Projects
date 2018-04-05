package com.info.model;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.info.service.MessageService;




@Configuration
@ComponentScan(basePackages = {"com.info.model","com.info.service"})
class Configs {

}

public class AutowiredConstructor {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Configs.class);
		context.refresh();
		MessageService service= context.getBean(MessageService.class);
		System.out.println(service.getMessage().getEmpMsg());
		context.close();
	}

}
