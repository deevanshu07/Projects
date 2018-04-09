package com.info.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class DeleteController extends ActionSupport implements SessionAware 
{

	private Map session;
	public static List list;


	String itemselected;
	public String getItemselected() {
		return itemselected;
	}


	public void setItemselected(String itemselected) {
		this.itemselected = itemselected;
	}





	public Item getItemsd() {
		return itemsd;
	}


	public void setItemsd(Item itemsd) {
		this.itemsd = itemsd;
	}

	Item itemsd;

	
	public String deleteitems()
	{
		list=new ArrayList<>();
		list=SaveOrder.ordercart;
		
		
		Iterator iterator= list.iterator();
		System.out.println(list);
		while(iterator.hasNext())
		{
			itemsd=(Item)iterator.next();
			if(itemsd.itemName.equals(itemselected))
			{
				System.out.println(itemselected);
				list.remove(itemsd);
				break;
			}
			
		}
		
		System.out.println(list);
		session.put("list",list);
		return SUCCESS;
	}
	

	public Map getSession() {
		return session;
	}

	
	
	
	@Override
	public void setSession(Map<String, Object> arg0)
	{
		session=arg0;
		
	}
	
}
