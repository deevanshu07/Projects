package com.info.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("customerBean")
public class Shop {
	
	@Value("#{itemBean}")
	private Item item;
	
	@Value("#{itemBean.name}")
	private String itemName;
	public Item getItem() {
		return item;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	@Override
	public String toString() {
		return "Shop [item=" + item + ", itemName=" + itemName + "]";
	}


}
