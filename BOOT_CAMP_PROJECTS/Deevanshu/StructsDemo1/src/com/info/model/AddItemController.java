package com.info.model;

import com.info.model1.Item;
import com.infy.model.MenuService;
import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class AddItemController extends ActionSupport 
{
	private int itemId;
	private String itemName;
	private String itemDesc;
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
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String execute(){
		Item item=new Item(itemId,itemName,itemDesc);
		MenuService service=new MenuService();
		if(service.addItem(item)==1)
		{
			return SUCCESS;	
		}
		else
		{
			return NONE;
		}
		
	}
	
	public void validate()
	{
		if(itemName.length()==0)
		{
			addFieldError("itemName", "Name can't be empty");
		}
	}
	
	/*public String add()
	{
		return SUCCESS;
	}*/
	
}
