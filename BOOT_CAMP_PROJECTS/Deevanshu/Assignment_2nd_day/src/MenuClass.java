import java.util.ArrayList;


public class MenuClass 
{

	


	static ArrayList<itemClass> orderCart = new ArrayList <itemClass>();
		
		static
		{	
			
			
			itemClass item1= new itemClass(1,"Pizza",10,1000);
			orderCart.add(item1);
			itemClass item2=new itemClass(2,"Burger",10,500);
			orderCart.add(item2);
			itemClass item3=new itemClass(3,"Beer",30,400);
			orderCart.add(item3);
		}		
		 void display()
		{
				for (int i = 0; i < orderCart.size(); i++) 
				{
						System.out.println("Item id ="+orderCart.get(i).getItemId()+"\t"
											+"Item Name ="+orderCart.get(i).getItemName()+"\t"
											+"Item Prepartion Time="+orderCart.get(i).getItemPrepTime()+"\t"
											+"Item Price = "+orderCart.get(i).getPrice()+"\t");
						
						
						
						
				}
				System.out.println("\n");
		
			}
	


}
