package com.info.ejb;

import java.io.Serializable;

public class Item implements Serializable
{
	private int itemId;
	private String itemName;
	private int prepTime;
	
	public int getItemId() 
	{
		return itemId;
	}
	public void setItemId(int itemId) 
	{
		this.itemId = itemId;
	}
	public String getItemName() 
	{
		return itemName;
	}
	public void setItemName(String itemName) 
	{
		this.itemName = itemName;
	}
	public int getPrepTime() 
	{
		return prepTime;
	}
	public void setPrepTime(int prepTime) 
	{
		this.prepTime = prepTime;
	}
	public Item(int itemId, String itemName, int prepTime) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.prepTime = prepTime;
	}
}
