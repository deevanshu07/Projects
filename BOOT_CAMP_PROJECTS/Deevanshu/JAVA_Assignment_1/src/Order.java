import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
 class Order {

	 itemClass item = new itemClass();
		Date orderDate;
		
		static int count=0;
		static int time=0;
		
		
		 ArrayList<itemClass> orderCart=new ArrayList<itemClass>();
		static int tokenNumber;
		MenuClass menu = new MenuClass();
		
		
		void byid( int id2)
		{
		
	
		orderDate= new Date();
		
		
		for(int i=0;i<3;i++)
		{
			
			
			if(id2==(menu.itemMenu[i].getItemId()))
			{
				
				time=menu.itemMenu[i].getItemPrepTime();
				System.out.println("Item Id= "+menu.itemMenu[i].getItemId()
						+"\n"+"Item Name="+menu.itemMenu[i].getItemName()+
						"\n"+"Item Preparation Time="+menu.itemMenu[i].getItemPrepTime());
				
				
				itemClass item = new itemClass
			(menu.itemMenu[i].getItemId(),menu.itemMenu[i].getItemName(),menu.itemMenu[i].getItemPrepTime());
			
				
				System.out.print("Items in the Cart are=");
				
				System.out.println("Token number="+tokenNumber+++" is Under Processing");
				
				System.out.println("Order Date ="+orderDate);
				System.out.println("\n");
				
				
				
				
				
				System.out.println("Total Wait Time is:");
				time =(menu.itemMenu[i].getItemPrepTime());
				
				System.out.println(time);
				
				
				
			
				
				
			}
			
		
		}
		orderCart.add(item);
		
		
			
			
		}
			
	
		
		
			
		
		
	
		
		void byname(String name)
		{
			
			
			orderDate= new Date();
			
			
			for(int i=0;i<3;i++)
			{
								
				if(name.equalsIgnoreCase(menu.itemMenu[i].getItemName()))
				{
					
					time=menu.itemMenu[i].getItemPrepTime();
					System.out.println("Item Id= "+menu.itemMenu[i].getItemId()
							+"\n"+"Item Name="+menu.itemMenu[i].getItemName()+
							"\n"+"Item Preparation Time="+menu.itemMenu[i].getItemPrepTime());
					
					
					itemClass item = new itemClass
				(menu.itemMenu[i].getItemId(),menu.itemMenu[i].getItemName(),menu.itemMenu[i].getItemPrepTime());
					
				
					System.out.println("Token number="+tokenNumber+++" is Under Processing");
					
					System.out.println("Order Date ="+orderDate);
					
					
					
					
					System.out.println("\n");
					
					
					System.out.println("Total Waiting Time is:");
					System.out.println(time);
				
					
					
		}
				
			
	
	}
			orderCart.add(item);
			
		}}


 
 



