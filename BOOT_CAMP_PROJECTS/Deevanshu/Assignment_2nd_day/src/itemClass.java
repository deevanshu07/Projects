
public class itemClass 
{
	@Override
	public String toString() {
		return "itemClass [itemId=" + itemId + ", itemName=" + itemName
				+ ", itemPrepTime=" + itemPrepTime + ", price=" + price + "]";
	}

	int itemId;
	String itemName;
	int itemPrepTime;
	double price;
	
	int date;
	
	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	itemClass(int i)
	{
		
	}
	
	itemClass()
	{
		
	}
	

	itemClass(int i,String n,int p,double pr)
	{
		itemId=i;
		itemName=n;
		itemPrepTime=p;
		price=pr;
	}
	
	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}




	public int getItemId() 
	{
		return itemId;
	}


    public void setItemId(int itemId) 
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


    public int getItemPrepTime()
	{
		return itemPrepTime;
	}

    public void setItemPrepTime(int itemPrepTime) 
	{
		this.itemPrepTime = itemPrepTime;
	}
	

}


