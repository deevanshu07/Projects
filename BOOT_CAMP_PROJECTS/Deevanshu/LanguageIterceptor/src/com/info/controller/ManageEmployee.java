package com.info.controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAware;
/**
 * Servlet implementation class ListEmployees
 */
@SuppressWarnings({ "serial", "unused" })
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

	public String add()
	{
		if(name.equals("Admin")&&pass.equals("1234"))
		{
			return SUCCESS;
		}
		
		else
		{
			return NONE;
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
	
}

