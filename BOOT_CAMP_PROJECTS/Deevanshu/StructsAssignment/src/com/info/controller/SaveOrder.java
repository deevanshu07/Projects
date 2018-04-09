package com.info.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.spring.interceptor.ActionAutowiringInterceptor;


public class SaveOrder extends ActionSupport implements SessionAware
{

	
	
	@Override
	public String toString() 
	{
		return "SaveOrder [itemselected=" + itemselected + ", quantity="
				+ quantity + ", ordercart=" + ordercart + ", item=" + item
				+ "]";
	}
	private String itemselected;
	private int quantity;
	private String username;
	private String contactnumber;
	public static  ArrayList<Item> ordercart;
	public static List<Order> orderqueue = new ArrayList<Order>();
	private Item item;
	private Map<String, Object> session;
	
	


	public String saveorder()
	{
		ordercart=new ArrayList<Item>();
		Order order= new Order();
		System.out.println(itemselected);
		Iterator ite = MenuService.items.iterator();
		while(ite.hasNext())
		{
			item= (Item)ite.next();
			if(item.getItemName().equals(itemselected))
			{
				break;
			}
		}
		
		if(!(session.get("oc")==null))
		{
			ordercart.addAll((ArrayList<Item>)session.get("oc"));
		}

		item.setQuantity(quantity);
		ordercart.add(new Item(item.getItemId(),item.getItemName(),
				item.getItemPrepTime(),item.getItemPrice(),item.getQuantity()));
		order.setOrder(ordercart);
		System.out.println("Order cart"+ ordercart);
		orderqueue.add(order);
		System.out.println(""+orderqueue);
		session.put("oc",ordercart);
		return SUCCESS;
	}
	
	

	public String getContactnumber() {
		return contactnumber;
	}
	public Item getItem() {
		return item;
	}
	public String getItemselected() {
		return itemselected;
	}
	public ArrayList<Item> getOrdercart() {
		return ordercart;
	}
	public List<Order> getOrderqueue() {
		return orderqueue;
	}
	public int getQuantity() {
		return quantity;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public String getUsername() {
		return username;
	}
	
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	public void setItemselected(String itemselected) {
		this.itemselected = itemselected;
	}
	public void setOrdercart(ArrayList<Item> ordercart) {
		this.ordercart = ordercart;
	}
	
	public void setOrderqueue(List<Order> orderqueue) {
		this.orderqueue = orderqueue;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setSession(Map<String, Object> arg0) 
	{
		session=arg0;
		
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

	

}
