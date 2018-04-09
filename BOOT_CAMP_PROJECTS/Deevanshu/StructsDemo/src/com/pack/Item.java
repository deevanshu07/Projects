package com.pack;

import java.util.ArrayList;
import java.util.List;

public class Item 
{

	public int itemId;
	public Item(int itemId, String itemName, String itemPrepTime,int itemPrice) 
	{
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrepTime = itemPrepTime;
		this.itemPrice = itemPrice;
	}
	
	
	public String itemName;
	public String itemPrepTime;
	public int itemPrice;
	public int quantity;
	
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
	public String getItemPrepTime() 
	{
		return itemPrepTime;
	}
	public void setItemPrepTime(String itemPrepTime) 
	{
		this.itemPrepTime = itemPrepTime;
	}
	public int getItemPrice() 
	{
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) 
	{
		this.itemPrice = itemPrice;
	}
	public int getQuantity() 
	{
		return quantity;
	}
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	@Override
	public String toString() 
	{
		return "Item [itemId=" + itemId + ", itemName=" + itemName
				+ ", itemPrepTime=" + itemPrepTime + ", itemPrice=" + itemPrice
				+ ", quantity=" + quantity + "]";
	}
	
	public Item(int itemId, String itemName, String itemPrepTime,
			int itemPrice, int quantity) 
	{
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrepTime = itemPrepTime;
		this.itemPrice = itemPrice;
		this.quantity = quantity;
	}
	

	
	
	
	
	
	
}
