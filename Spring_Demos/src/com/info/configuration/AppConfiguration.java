package com.info.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.info.service.MailService;
import com.info.service.impl.MailServiceImpl;

@Configuration
public class AppConfiguration {


	
	@Bean(initMethod="init",destroyMethod="destroy")
	public MailService getMailService(){
		return new MailServiceImpl();
	}
	
	
}


