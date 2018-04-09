package model;

public class OrderStatus 
{

	String name;

	String number;

	String quantity;

	String itemName;

	public OrderStatus(String name, String number, String quantity, String itemName) {
		super();
		this.name = name;
		this.number = number;
		this.quantity = quantity;
		this.itemName = itemName;
	}

	public String getItemName() {
		return itemName;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public String getQuantity() {
		return quantity;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderStatus [name=" + name + ", number=" + number
				+ ", quantity=" + quantity + ", itemName=" + itemName + "]";
	}
	
}
