
public class itemClass 
{
	int itemId;
	String itemName;
	int itemPrepTime;
	
	itemClass()
	{
		
	}
	itemClass(int i,String n,int p)
	{
		itemId=i;
		itemName=n;
		itemPrepTime=p;
	}
	
	
	
	public static void main(String[] args) 
	{
		
		
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


