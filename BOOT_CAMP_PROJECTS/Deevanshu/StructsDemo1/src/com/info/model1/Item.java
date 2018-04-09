package com.info.model1;

public class Item 
{
	private int itemId;
	private String itemName;
	private String itemDesc;
	
	public Item(int itemId, String itemName, String itemDesc)
	{
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemDesc = itemDesc;
	}
	
	public String getItemDesc() 
	{
		return itemDesc;
	}
	
	public int getItemId() 
	{
		return itemId;
	}
	
	public String getItemName() 
	{
		return itemName;
	}
	
	public void setItemDesc(String itemDesc)
	{
		this.itemDesc = itemDesc;
	}
	
	public void setItemId(int itemId) 
	{
		this.itemId = itemId;
	}
	
	public void setItemName(String itemName) 
	{
		this.itemName = itemName;
	}
	

	

}
