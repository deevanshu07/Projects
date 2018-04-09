package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.info.controller.Item;
import com.info.controller.MenuService;
import com.opensymphony.xwork2.ActionSupport;



public class MenuAction extends ActionSupport implements SessionAware
{
	private Map session;
	MenuS
	

public String add()
{
	return SUCCESS;
}


@Override
public void setSession(Map<String, Object> arg0) {
	session=arg0;
	
}

/*
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
*/




}
