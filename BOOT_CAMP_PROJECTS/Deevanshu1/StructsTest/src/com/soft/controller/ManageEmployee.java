package com.soft.controller;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAware;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

public class ManageEmployee extends ActionSupport implements ApplicationAware,ServletRequestAware,ServletResponseAware,RequestAware, SessionAware{
	private String name;
	private String pass;
	private Map session;
	private Map ctx;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String listEmployee()
	{
		if(name.equals("Admin")&&pass.equals("12345"))
		{
			session.put("user", name);
			
			
			return "success1";
		}
		else if(name.equals("user") && pass.equals("12345"))
		{
			return "success";
		}
		else
		{
			return "none";
		}
		        
	}
	public String listDepartment()
	{
		if(name.equals("Admin")&&pass.equals("12345"))
		{
			session.put("user", name);
			return "success2";
		}
		else if(name.equals("user") && pass.equals("12345"))
		{
			addActionError("You are not authorized......");
			return "input";
		}
		else
		{
			return "none";
		}
		        
	}
		/*public void validate() {
		
		if(name.equals("")&&(pass.equals("")))
		{
			System.out.println("Please fill up");
			//addActionError("Fields are empty");
			
			addFieldError("name", "Name can not be empty");
			addFieldError("pass", "Pass can not be empty");
			//addActionMessage("Fields are empty");
		}
		else
		{
			addActionMessage("Welcome"+name);
		}
		
	 }	*/

	@Override
	public void setSession(Map<String, Object> arg0) {
		session=arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
	
		
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
				
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
	
		
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		ctx=arg0;
		
	}
	
}
