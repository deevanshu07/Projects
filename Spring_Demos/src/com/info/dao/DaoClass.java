package com.info.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:confog.properties")	
public class DaoClass {

@Autowired 
private Environment env;

@Bean
public StringBuffer getData(){
	StringBuffer buff= new StringBuffer();
	buff.append(env.getProperty("db.password"));
	return buff;
	
}

}
