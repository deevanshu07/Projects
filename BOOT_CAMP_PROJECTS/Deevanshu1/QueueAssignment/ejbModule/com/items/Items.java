package com.items;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.ServletContext;


public class Items implements Serializable{
	int itemId;
	String itemName;
	public int getItemId() 
		{
		return itemId;
	}
	public void setItemId(int itemId) 
	{
		this.itemId = itemId;
	}
	public Items() 
	{
		super();
		
	}
	public Items(int itemId, String itemName) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
		
	

}
