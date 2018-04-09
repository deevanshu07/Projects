package com.infy.model;

public class Item 
{
	Manufacturer menu;
	public Manufacturer getMenu() {
		return menu;
	}

	public void setMenu(Manufacturer menu) {
		this.menu = menu;
	}
	private int itemId;
	private String itemName;
	private double itemPrice;
	public Item(int itemId,Manufacturer menu, String itemName, double itemPrice) {
		super();
		
		this.itemId=itemId;
		this.menu=menu;
		this.itemName=itemName;
		this.itemPrice=itemPrice;
	}
	
	public Item()
	{
		
	}
	public int getItemId() {
		return itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "Item [menu=" + menu + ", itemId=" + itemId + ", itemName="
				+ itemName + ", itemPrice=" + itemPrice + "]";
	}
	

	

}
