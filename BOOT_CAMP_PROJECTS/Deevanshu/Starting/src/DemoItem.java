import java.util.ArrayList;
import java.util.Collections;


public class DemoItem
{


	public static void main(String[] args) 
	{
		ArrayList <Item>itemList= new  ArrayList<Item>();
		
		itemList.add(new Item(101,"burger",20.50));
		itemList.add(new Item(107,"pizza",10.50));
		itemList.add(new Item(108,"cold-drink",15));
		itemList.add(new Item(104,"Sandwich",50));
		itemList.add(new Item(120,"Pen",5));
	
		
		System.out.println(itemList);
		
	}

}
