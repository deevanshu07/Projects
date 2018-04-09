package model;

 public class ItemClass 
 {
	
	 String itemId;
	public String itemName;
	 int price;
	 String itemDesc;
	 
public ItemClass(String itemId, int price, String itemName, String itemDesc) 
{
	super();
	this.itemId = itemId;
	this.itemName = itemName;
	this.price = price;
	this.itemDesc = itemDesc;
}


public String getItemId() 
{
	return itemId;
}
public void setItemId(String itemId) 
{
	this.itemId = itemId;
}
public String getItemName() 
{
	return itemName;
}
public void setItemName(String itemName)
{
	this.itemName = itemName;
}
public int getPrice() 
{
	return price;
}
public void setPrice(int price) 
{
	this.price = price;
}
public String getItemDesc()
{
	return itemDesc;
}
public void setItemDesc(String itemDesc) 
{
	this.itemDesc = itemDesc;
}

@Override
public String toString()
{
	return "ItemClass [itemId=" + itemId + ", itemName=" + itemName
			+ ", price=" + price + ", itemDesc=" + itemDesc + "]";
}
	 
	
	
	

}
	