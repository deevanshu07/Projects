package com.pack;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Controller extends ActionSupport implements SessionAware
{
	
	String name;
	String pass;
	private Map session;
	List <Item>itemList=MenuService.addItem();
	
	
	public String getName() 
	{
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
		return SUCCESS;
	}

	
	public String addItem()
	{
		
		session.put("category",itemList);
	
		return SUCCESS;
	}


	public Map getSession() {
		return session;
	}


	


	public List<Item> getItemList() {
		return itemList;
	}


	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}


	@Override
	public void setSession(Map<String, Object> arg0) 
	{
		session=arg0;
		
	}
	
		
		

}
