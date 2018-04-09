package com.pack;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemController extends ActionSupport implements SessionAware
{

	
	int iId;
	
	String itemselected;
	String iprepTime;;
	
	Update update = new Update();
	public String getIprepTime() {
		return iprepTime;
	}

	public void setIprepTime(String iprepTime) {
		this.iprepTime = iprepTime;
	}

	public AddItem getItemAdded() {
		return itemAdded;
	}

	public void setItemAdded(AddItem itemAdded) {
		this.itemAdded = itemAdded;
	}
	int iPrice;
	AddItem itemAdded= new AddItem();

	public int getiId() {
		return iId;
	}

	public void setiId(int iId) {
		this.iId = iId;
	}


	public String getItemselected() {
		return itemselected;
	}

	public void setItemselected(String itemselected) {
		this.itemselected = itemselected;
	}

	public int getiPrice() {
		return iPrice;
	}

	public void setiPrice(int iPrice) {
		this.iPrice = iPrice;
	}

	
	public String putItem()
	{
		
		
		Item item= new Item(iId,itemselected,iprepTime,iPrice);
		if(itemAdded.add(item)>0)
		{
			
			return "success1";
			
		}
		
		else
		return SUCCESS;
		
	}
	@Override
	public void setSession(Map<String, Object> arg0) 
	{
		
		
	}

	

}
