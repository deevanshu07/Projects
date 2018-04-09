
public class Item implements Comparable<Item>{


		@Override
	public String toString() {
			
			
		return "Item [itemId=" + itemId + ", itemName=" + itemName
				+ ", itemPrice=" + itemPrice +"]"+"\n";
	
		}
		int itemId;
		String itemName;
		double itemPrice;
		

	

	public Item() 
	{
		super();
	
	}
	
	public  Item(int id, String name,double price)
	{
		this.itemId=id;
		this.itemName=name;
		this.itemPrice=price;
	}

	@Override
	public int compareTo(Item arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
