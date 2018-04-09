class Item
{
	public int itemId;
	public String itemName,itemPrepTime;
	
	Item(int i, String name, String prep)
	{
		itemId=i;
		name=itemName;
		prep=itemPrepTime;
	}
	
	
	void display()
	{
		System.out.println( this.itemId+ this.itemName + this.itemPrepTime);
	}
}



class Menu
{
	static 
	
	{
	Item itemtype[] = new Item[3];
	itemtype[0]= new Item(101,"Icecream","Monday");
	itemtype[1]= new Item(102,"Icecream","Monday");
	itemtype[2]= new Item(103,"Icecream","Monday");
	itemtype[3]= new Item(104,"Icecream","Monday");
	}
}