package com.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Controller extends ActionSupport implements SessionAware 
{

	String username;
	public String getUsername() 
	{
		return username;
		
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public Map getSession() 
	{
		return session;
	}

	

	String password;
	
	private Map session;
	
	HttpSession hs= ServletActionContext.getRequest().getSession();
	
	public String execute()
	{
		if(!hs.isNew())
		{

		if(username.equalsIgnoreCase("ADMIN")&& password.equalsIgnoreCase("ADMIN"))
		{
			
			session.put("ADMIN", username);
			
		}
		return SUCCESS;
		}
		else 
			return "none";
		
	}
	
	public String logout()
	{
		HttpSession hs=ServletActionContext.getRequest().getSession();
		hs.invalidate();
		return "success";
	}

	@Override
	public void setSession(Map<String, Object> arg0)
	{
		session=arg0;
		
	}
	

}
