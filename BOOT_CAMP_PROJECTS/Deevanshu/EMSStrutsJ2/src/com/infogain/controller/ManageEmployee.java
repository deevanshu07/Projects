package com.infogain.controller;

import com.opensymphony.xwork2.Action;

public class ManageEmployee{
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
			return "input";
		}
		else
		{
			return "none";
		}
		        
	}
}

