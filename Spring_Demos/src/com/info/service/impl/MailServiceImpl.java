package com.info.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.info.service.MailService;

public class MailServiceImpl implements MailService {
private Map<String, String> map = null;
	
	public MailServiceImpl(){
		map= new HashMap<String, String>();	
	}
	
	 public void send(String mailTo){
	      //Code for sending mail
	      System.out.println("Inside send method - "+mailTo);
	   }
	

	public void init(){
		 map.put("host", "mail.example.com");
	      map.put("port", "25");
	      map.put("from", "example@boraji.com");
	      System.out.println("Inside init method - "+map);
	}
	

	public void destroy(){
		 map.clear();
	      System.out.println("Inside destroy method - "+map);
	}
}
