package model;

public class CustomerOrder 
{




	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}




	String orderId;
	String itemName;
	
	 
	
	public CustomerOrder(String orderId, String itemName) 
	{
		super();
		this.orderId = orderId;
		this.itemName = itemName;
		
	}
	
	
	public String toString()
	{
		return "CustomerOrder [orderId=" + orderId + ", itemName=" + itemName
			+ "]";
	}

	
	

}
