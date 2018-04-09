import java.util.ArrayList;
import java.util.Random;
import java.util.Date;
import java.util.Scanner;
 class Order 
 {
	






	MenuClass menu = new MenuClass();
	itemClass item = new itemClass();
	Date orderDate = new Date();

	
		  
	double price=0;
	int time=0;
	int price1=0;
	int price2=0;
	static int i=0;
		
		
		
	static ArrayList<itemClass> orderCart2 = new ArrayList <itemClass>();
	static int tokenNumber=++i;
	static ArrayList <itemClass> order_time = new ArrayList<itemClass>() ;
		
	

	static ArrayList<Offer> offer = new ArrayList<Offer>();
	{
		offer.add(new RegularOffer(1, "Regular", "Weekend", "20 minutes", "Monday"));
		offer.add(new RegularOffer(2, "Regular", "Weekdays", "10 minutes", "Sunday"));
		offer.add(new CorporateOffer(3, "Corporate", "Weekend", "30 minutes", "Sunday"));
		offer.add(new CorporateOffer(4, "Corporate", "Weekend", "10 minutes", "Monday"));
		offer.add(new CorporateOffer(5, "Corporate", "Weekdays", "20 minutes", "Sunday"));
		offer.add(new CorporateOffer(6, "Regular", "Weekdays", "20 minutes", "Sunday"));
	}
	
	
	void order_byidr( int id2, int how_many)
	{
		
		for(int z=0;z<how_many;z++)
		for(int i=0;i<3;i++)
		{
			
			if(id2==menu.orderCart.get(i).getItemId())
			{
			
				for(int j=0;j<offer.size();j++)
		{	
				
	
				
				if(orderDate.toString().substring(0, 3).equalsIgnoreCase("MON") || orderDate.toString().substring(0, 3).equalsIgnoreCase("tue") 
						||orderDate.toString().substring(0, 3).equalsIgnoreCase("wed") || orderDate.toString().substring(0, 3).equalsIgnoreCase("thr")
						||orderDate.toString().substring(0, 3).equalsIgnoreCase("fri") && id2==1)
				{
					
				
				

					orderCart2.add(new itemClass(menu.orderCart.get(i).getItemId(),
							  menu.orderCart.get(i).getItemName(),
					          menu.orderCart.get(i).getItemPrepTime()
					         ,menu.orderCart.get(i).getPrice()));
					System.out.println(orderCart2);






int d= orderDate.getHours()*3600+orderDate.getMinutes()*60+orderDate.getSeconds();



itemClass item1 = new itemClass(d);
item1.setDate(d);
order_time.add(item1);



time+=(menu.orderCart.get(i).getItemPrepTime());
price+=menu.orderCart.get(i).getPrice();


System.out.println("You got 1 free Pizza");
break;
}

				else
				{




orderCart2.add(new itemClass(menu.orderCart.get(i).getItemId(),
		  menu.orderCart.get(i).getItemName(),
          menu.orderCart.get(i).getItemPrepTime()
         ,menu.orderCart.get(i).getPrice()));




int d= orderDate.getHours()*3600+orderDate.getMinutes()*60+orderDate.getSeconds();



itemClass item1 = new itemClass(d);
item1.setDate(d);
order_time.add(item1);



time+=(menu.orderCart.get(i).getItemPrepTime());
price+=menu.orderCart.get(i).getPrice();
break;


}
 
				
				

 }

		
		
		
			}
		
		}		
		
		System.out.println("Token number="+tokenNumber+" is Under Processing");
		System.out.println
		("Item Id= "+menu.orderCart.get(i).getItemId()
				+"\n"+"Item Name="+menu.orderCart.get(i).getItemName()+
				"\n"+"Item Preparation Time="+menu.orderCart.get(i).getItemPrepTime());
		System.out.println("The total price is"+price);
		if(price>1000)
			System.out.println("You got discount of 10% "+(price*10)/100);
		else
			System.out.println("The price without discount="+price);
	}			
					
	
	
	
	void order_byidc( int id2, int how_many)
	{
		
		for(int z=0;z<how_many;z++)
		for(int i=0;i<3;i++)
		{
			
			if(id2==menu.orderCart.get(i).getItemId())
			
			{
				
					System.out.println
					("Item Id= "+menu.orderCart.get(i).getItemId()
							+"\n"+"Item Name="+menu.orderCart.get(i).getItemName()+
							"\n"+"Item Preparation Time="+menu.orderCart.get(i).getItemPrepTime());



itemClass item = new itemClass(menu.orderCart.get(i).getItemId(),
		  menu.orderCart.get(i).getItemName(),
          menu.orderCart.get(i).getItemPrepTime()
         ,menu.orderCart.get(i).getPrice());



System.out.println("Token number="+tokenNumber+" is Under Processing");

System.out.println("Order Date ="+orderDate);
System.out.println("\n");
orderCart2.add(item);
//System.out.println(orderCart2.get(i).getItemId());
int d= orderDate.getHours()*3600+orderDate.getMinutes()*60+orderDate.getSeconds();
//System.out.println("Order is placed at"+d);


itemClass item1 = new itemClass(d);
item1.setDate(d);
order_time.add(item1);

System.out.println("Item Price ="+ menu.orderCart.get(i).getPrice());

time+=(menu.orderCart.get(i).getItemPrepTime());
price+=menu.orderCart.get(i).getPrice();
break;


}
 
		}		
				
	
		
		System.out.println("The total price is"+price);
		if(price>1000)
			System.out.println("You win a Meal Voucher of 50 rupees");
		
	}
 }				
						
				
						
						/*	{
				
							System.out.println
												("Item Id= "+menu.orderCart.get(i).getItemId()
												+"\n"+"Item Name="+menu.orderCart.get(i).getItemName()+
											   "\n"+"Item Preparation Time="+menu.orderCart.get(i).getItemPrepTime());
						
				
				
				itemClass item = new itemClass(menu.orderCart.get(i).getItemId(),
											  menu.orderCart.get(i).getItemName(),
								              menu.orderCart.get(i).getItemPrepTime()
					                         ,menu.orderCart.get(i).getPrice());
			
				
				
				System.out.println("Token number="+tokenNumber+" is Under Processing");
				
				System.out.println("Order Date ="+orderDate);
				System.out.println("\n");
				orderCart2.add(item);
				//System.out.println(orderCart2.get(i).getItemId());
				int d= orderDate.getHours()*3600+orderDate.getMinutes()*60+orderDate.getSeconds();
				//System.out.println("Order is placed at"+d);
				
				
				itemClass item1 = new itemClass(d);
				item1.setDate(d);
				order_time.add(item1);
				
				System.out.println("Item Price ="+ menu.orderCart.get(i).getPrice());
				
				time+=(menu.orderCart.get(i).getItemPrepTime());
				price+=menu.orderCart.get(i).getPrice();
				
				System.out.println("Discount is One Pizza is Free");
				
					break;
			}
				
						else
						{
							System.out.println("Item Id= "+menu.orderCart.get(i).getItemId()
									+"\n"+"Item Name="+menu.orderCart.get(i).getItemName()+
									"\n"+"Item Preparation Time="+menu.orderCart.get(i).getItemPrepTime());
									
							
							
							itemClass item = new itemClass
						(menu.orderCart.get(i).getItemId(),menu.orderCart.get(i).getItemName(),menu.orderCart.get(i).getItemPrepTime()
								,menu.orderCart.get(i).getPrice());
						
							
							
							System.out.println("Token number="+tokenNumber+" is Under Processing");
							
							System.out.println("Order Date ="+orderDate);
							System.out.println("\n");
							orderCart2.add(item);
							//System.out.println(orderCart2.get(i).getItemId());
							int d= orderDate.getHours()*3600+orderDate.getMinutes()*60+orderDate.getSeconds();
							//System.out.println("Order is placed at"+d);
							
							
							itemClass item1 = new itemClass(d);
							item1.setDate(d);
							order_time.add(item1);
							
							
							System.out.println("Item Price ="+menu.orderCart.get(i).getPrice());
							time+=(menu.orderCart.get(i).getItemPrepTime());
							price+=menu.orderCart.get(i).getPrice();	
							break;
						}
		
		}
		}
					if(price>1000)
					System.out.println("The total Discount Given ="  +  (price*10)/100);
			
		
		}
		
		}
			*/
 
		
		/*void byname(String name)
		{
			
			
			orderDate= new Date();
			
			
			for(int i=0;i<3;i++)
			{
				if(name.equalsIgnoreCase(menu.orderCart.get(i).getItemName()))
				{
					
					
					System.out.println("Item Id= "+menu.orderCart.get(i).getItemId()
							+"\n"+"Item Name="+menu.orderCart.get(i).getItemName()+
							"\n"+"Item Preparation Time="+menu.orderCart.get(i).getItemPrepTime()
							+"\n"+"Item Price"+menu.orderCart.get(i).getPrice());
					
					
	itemClass item = new itemClass
							       (menu.orderCart.get(i).getItemId(),
									menu.orderCart.get(i).getItemName(),
									menu.orderCart.get(i).getItemPrepTime()
								   ,menu.orderCart.get(i).getPrice());
				
					
					
					System.out.println("Token number="+tokenNumber+++" is Under Processing");
					
					System.out.println("Order Date ="+orderDate);
					System.out.println("\n");
					orderCart2.add(item);
					System.out.println(orderCart2.get(i).getItemId());
					
					
					time+=(menu.orderCart.get(i).getItemPrepTime());
					price+=menu.orderCart.get(i).getPrice();
					
					
			}
		
		}
		
			System.out.println(price+time);
			
			
		

}*/
		
 
		


 
