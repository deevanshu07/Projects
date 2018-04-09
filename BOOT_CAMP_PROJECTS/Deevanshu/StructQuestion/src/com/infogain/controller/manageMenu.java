package com.infogain.controller;
import com.opensymphony.xwork2.Action;
public class manageMenu 
{
private int itemId;
private String itemName;
private String itemView;
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
public String getItemView() {
	return itemView;
}
public void setItemView(String itemView) {
	this.itemView = itemView;
}

public String showmenu()
{
	return "success";
}

public String listitems()
{
	return "success";
}
	

}
