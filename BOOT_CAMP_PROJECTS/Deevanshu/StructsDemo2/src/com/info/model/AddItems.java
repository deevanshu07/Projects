package com.info.model;

import com.opensymphony.xwork2.ActionSupport;

public class AddItems extends ActionSupport 
{
	private int itemId;
	public AddItems(int itemId, String itemName, String itemDesc) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
	}
	private String itemName;
	private String itemDesc;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	
	public String execute()
	{
		return SUCCESS;
	}
	
	public void validate()
	{
		if(itemName.length()==0)
		{
			addFieldError(itemName, "Name can't be empty");
		}
	}
}
