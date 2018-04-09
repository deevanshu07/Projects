package com.info.controller;

import com.opensymphony.xwork2.ActionSupport;

public class Item extends ActionSupport
{

	private int itemid;
	private String itemname;
	public int getItemId() {
		return itemid;
	}
	public void setItemId(int itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	
	
	public String execute()
	{
		return SUCCESS;
	}
	public void validate() {
		
		if(itemname.equals(""))
		{
			System.out.println("Please fill up");
			//addActionError("Fields are empty");
			
			addFieldError("name", "Name can not be empty");
			addFieldError("pass", "Pass can not be empty");
			//addActionMessage("Fields are empty");
		}
		
		
	 }

}
