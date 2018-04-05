package com.info.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.info.service.impl.BeanB;


@Configuration
@Import(value={AppConfiguration.class})
public class NewApp {
	@Bean(name="beanB")
	public BeanB getBean(){
		return new BeanB();
		
	}
}
