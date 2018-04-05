package com.info.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("itemBean")
public class Item {

	@Value("Maggi")
	private String name;
	@Value("10")
	private String quantity;

	public String getName() {
		return name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", quantity=" + quantity + "]";
	}

}
