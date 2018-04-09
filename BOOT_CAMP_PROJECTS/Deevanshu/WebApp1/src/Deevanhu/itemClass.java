package Deevanhu;



public class itemClass 
{
	

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrepTime() {
		return itemPrepTime;
	}

	public void setItemPrepTime(String itemPrepTime) {
		this.itemPrepTime = itemPrepTime;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "itemClass [itemId=" + itemId + ", itemName=" + itemName
				+ ", itemPrepTime=" + itemPrepTime + ", price=" + price + "]";
	}

	String itemId;
	public itemClass(String itemId, String itemName, 
			int price,String i) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrepTime = i;
		this.price = price;
	}

	public itemClass(String itemId2, String itemName2, int price2, int price3) {
		// TODO Auto-generated constructor stub
	}

	String itemName;
	
	int price;
	String itemPrepTime;
	
	int date;
	
}