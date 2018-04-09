package com.info.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;



public class MenuAction extends ActionSupport
{
	
	public int itemId;
	public String itemName;
	public String itemPrepTime;
	public int itemPrice;

	
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


	public String getItemPrepTime() {
		return itemPrepTime;
	}


	public void setItemPrepTime(String itemPrepTime) {
		this.itemPrepTime = itemPrepTime;
	}


	public int getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}


public String add()
{
	return SUCCESS;
}


public String additem()
{
	AddItems items= new AddItems();
	Item item= new Item(itemId, itemName, itemPrepTime, itemPrice);
	if(items.additem(item)==1)
	{
		return "success";
	}
	
	else
		return "fail";
			
}





}
