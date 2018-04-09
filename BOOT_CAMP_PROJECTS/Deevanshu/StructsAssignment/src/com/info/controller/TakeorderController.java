 package com.info.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class TakeorderController extends ActionSupport implements SessionAware 
{
	private Map session;
	static MenuService menu = new MenuService();
	static ArrayList<Item> item= menu.addItem();
	Item itembill;
	
	public static List<Item> bill;
	
	public  List finalbill;
	  int totalbill;
	static int count;
	
	
	public String submit()
	{
		return SUCCESS;
	}
	
	
	@SuppressWarnings("unchecked")
	public String showlist()
	{ 
		
		session.put("category", item);	
		return SUCCESS;				
	}
	
	public String delete()
	{
		return SUCCESS;
	}
	
	public String generatebill()
	{
		bill= new ArrayList<>();
		bill=DeleteController.list;
		finalbill= new ArrayList<>();
		System.out.println("Generating bill");
		Iterator itr= bill.iterator();
		while(itr.hasNext())
		{
			itembill=(Item)itr.next();
			totalbill =totalbill+(itembill.itemPrice * itembill.quantity);
		}
		
		finalbill.add(totalbill);
		session.put("bill",finalbill);
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) 
	{
		session=arg0;
	}

	public Map getSession() 
	{
		return session;
	}

}
