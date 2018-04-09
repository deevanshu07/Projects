package com.infogain.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAware;
/**
 * Servlet implementation class ListEmployees
 */
public class ManageEmployee extends ActionSupport{
	private String name;
	private String pass;
	
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
		if(name.equals("Admin")&&pass.equals("Admin"))
		{
			return "success";
		}
		else if(name.equals("user") && pass.equals("user"))
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
		if(name.equals("Admin")&&pass.equals("Admin"))
		{
			return "success";
		}
		else if(name.equals("user") && pass.equals("user"))
		{
			addActionError("You are not authorized......");
			return "input";
		}
		else
		{
			return "none";
		}
		        
	}
		public void validate() {
		
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
		
	 }	
	
}

