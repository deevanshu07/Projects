package com.infogain.controller;

import com.opensymphony.xwork2.Action;

/**
 * Servlet implementation class ListEmployees
 */
public class ListEmployees implements Action {
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

	public String execute()
	{
		if(name.equals("Admin")&&pass.equals("Admin"))
		{
			return SUCCESS;
		}
		else if(name.equals("user") && pass.equals("user"))
		{
			return INPUT;
		}
		else
		{
			return NONE;
		}
		        
	}
}

