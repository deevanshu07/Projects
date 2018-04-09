package Bean;

import java.io.Serializable;



public class Item implements Serializable
{

	private String itemName;
	private double itemPrice;
	private String itemDesc;
	private String itemValue;
	
public Item()
{
	
}
	public String getItemDesc() {
		return itemDesc;
	}
	public String getItemName() {
		return itemName;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public String getItemValue() {
		return itemValue;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}
	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", itemDesc=" + itemDesc + ", itemValue=" + itemValue + "]";
	}

}
