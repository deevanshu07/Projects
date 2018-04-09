import java.util.ArrayList;
import java.util.Scanner;


public class Restuarant implements IRestuarant 
{
	
	MenuClass menu = new MenuClass();
	 
	Order order= new Order();

	
	
	static ArrayList<Customer> customer = new ArrayList<Customer>();
	
	
	{
		customer.add(new RegularCustomer(101,"Customer1","12-2-14","123","Regular","noida"));
		customer.add(new CorporateCustomer(103,"Customer1","11-2-14","1233","Corporate","noida"));
		
		customer.add(new RegularCustomer(102,"Customer2","12-1-14","786","Regular","Delhi"));
		customer.add(new CorporateCustomer(104,"Customer2","11-5-14","1276","Corporate","Delhi"));
		
		customer.add(new RegularCustomer(105,"Customer3","1-12-14","1576","Regular","Agra"));
		customer.add(new CorporateCustomer(106,"Customer3","1-2-14","3456","Corporate","Agra"));
		
		
		}
	

	public void showMenu()
	{
		
		
		
		menu.display();
	}
	
	
	public void typeOfCustomer()
	{ 
		Restuarant  r= new Restuarant();
		Scanner input = new Scanner(System.in);
		MenuClass menu = new MenuClass();
		menu.display();
		boolean other=true;
		System.out.print("Enter the ID of Customer=");
		int n = input.nextInt();
		
		for(int i=0;i<customer.size();i++)
		{
			if(customer.get(i).getCustomerId()==n)
			{
				if(customer.get(i).getCustType().equalsIgnoreCase("Regular"))
				{	
					System.out.println("You Are a regular Customer");
					rtakeOrder(n);
					break;
				}
				else if(customer.get(i).getCustType().equalsIgnoreCase("Corporate"))
				{
					boolean c=customer.get(i).getCustType().equalsIgnoreCase("Corporate");
					System.out.println("You Are a Corporate Customer");
					ctakeOrder(n);
					break;
				}
			}
		}
			
			
				
			System.out.println("Not a Corporate or Regular Customer");
			System.out.println("So anyway place your order");
			rtakeOrder(n);
		}
	
	
	public void ctakeOrder(int type)
	{	
		
		menu.display();
		
		int c=0;
		System.out.println("Enter the Details of Order");
		int ch;
		String str, str1;
		int id=0;
		int how_Many;
		
		int flag=0;
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.println("Enter any one of the following to place the Order");
			System.out.println("Press 1 to Enter ItemId or Press 2 for Item Name");
			System.out.print("Enter Your Choice=");
			ch=Integer.parseInt(input.next());
			
			switch(ch)
			{
			case 1: try{
					System.out.println("What do you want to Order and enter its id=");
				 	
					id= input.nextInt();
				 	System.out.print("Enter how many "+ MenuClass.orderCart.get(id-1).getItemName()+" you want to order= ");
					
				 	how_Many=Integer.parseInt(input.next());
					
			        for(int i=0;i<menu.orderCart.size();i++)
			        {
			      
			        if(id==menu.orderCart.get(i).getItemId())
			        {
			         
			        order.order_byidc(id,how_Many);
			        flag =1;
			      
			      
			        }}
			         if(flag==0) 
			        {
			        	Exception except = new Exception("Item Not Available");
			         throw except;
			        }
			        
					}
			      
			catch(Exception e)
			{
				System.out.println(e);
				
			}
			
					break;
						
			       
			case 2: System.out.print("Enter the Item Name=");
					str=input.next();
					//order.order_byname(str);
					break;
					
			case 3: System.out.println("Press for Main Menu");
				break;
			
			
		
			
			
		
	}
		System.out.println("Press 1 to give more order");
		System.out.print("Press any other number to go to Main Menu=");
			c=input.nextInt();
			continue;
			
		
			
		}	

while(ch!=1 && ch!=2 || c==1);
	}
	
	
	
	
	public void rtakeOrder(int type)
	{	
		
		menu.display();
		
		int c=0;
		System.out.println("Enter the Details of Order");
		int ch;
		String str, str1;
		int id=0;
		int how_Many;
		
		int flag=0;
		Scanner input = new Scanner(System.in);
		do
		{
			System.out.println("Enter any one of the following to place the Order");
			System.out.println("Press 1 to Enter ItemId or Press 2 for Item Name");
			System.out.print("Enter Your Choice=");
			ch=Integer.parseInt(input.next());
			
			switch(ch)
			{
			case 1: try{
					System.out.println("What do you want to Order and enter its id=");
				 	
					id= input.nextInt();
				 	System.out.print("Enter how many "+ MenuClass.orderCart.get(id-1).getItemName()+" you want to order= ");
					
				 	how_Many=Integer.parseInt(input.next());
					
			        for(int i=0;i<menu.orderCart.size();i++)
			        {
			      
			        if(id==menu.orderCart.get(i).getItemId())
			        {
			         
			        order.order_byidr(id,how_Many);
			        flag =1;
			       
			        }}
			         if(flag==0) 
			        {
			        	Exception except = new Exception("Item Not Available");
			         throw except;
			        }
			        
					}
			      
			catch(Exception e)
			{
				System.out.println(e);
				
			}
			
					break;
						
			       
			case 2: System.out.print("Enter the Item Name=");
					str=input.next();
					//order.order_byname(str);
					break;
					
			
			
			
			default:
				System.out.println("Not a valid option Please try again : ");
				continue;
			
			
		
	}
		System.out.println("Press 1 to give more order");
		System.out.print("Press any other number to go to Main Menu=");
			c=input.nextInt();
			continue;
			
		
			
		}	

while(ch!=1 && ch!=2 || c==1);
	}
	
	public void checkStatus(int orderId)
	{
		Queue obj = new Queue();
		obj.waitingTime(orderId);
		
		
		
	}
	public void showRegCustomerOffer()
	{
		
		for(int i=0;i< Order.offer.size();i++)
		{
			if(Order.offer.get(i).OfferType.equalsIgnoreCase("Regular"))
			System.out.println(Order.offer.get(i));
			
		}
	}
	public void showCorpCustomerOffer()
	{
		for(int i=0;i< Order.offer.size();i++)
		{
			if(Order.offer.get(i).OfferType.equalsIgnoreCase("Corporate"))
			System.out.println(Order.offer.get(i));
			
		}
	}
	
	public static void main(String[] args) 
	{
		
		int choice=1;
		Scanner input;
		
		
		
		do
		{
			
			System.out.println("Enter 1 for Show Menu");
			System.out.println("Enter 2 for Take Order");
			System.out.println("Enter 3 for Check Status");
			System.out.println("Enter 4 for Show Register Customer Offer");
			System.out.println("Enter 5 for Show Corporate Customer Offer");
			
			System.out.println("Choose one option : ");
			input =new Scanner(System.in);
			choice=input.nextInt();
			switch(choice)
			{
				case 1:
					Restuarant r = new Restuarant();
					r.showMenu();
					break;
				case 2:
					Restuarant r1= new Restuarant();
					r1.typeOfCustomer();
					break;
				case 3:
					Restuarant r2= new Restuarant();
					System.out.println("Enter OrderId=");
					int oId=input.nextInt();
					r2.checkStatus(oId);
					break;
				case 4:
					Restuarant r3= new Restuarant();
					
					System.out.println("The corporation offer list is");
					
					
					r3.showRegCustomerOffer();
					
					
					break;
				case 5:
					Restuarant r4= new Restuarant();
					
					r4.showCorpCustomerOffer();
					break;
					
				case 6: System.out.println("Press 6 For exit");
						System.exit(0);
				break;
				default:
					System.out.println("Not a valid option Please try again : ");
					//if(choice!=1 || choice!=2 || choice!=3 || choice!=4 || choice!=5)
					//{
						continue;
					//}
			}
			
			
					
		}
		while(choice!=6);
		
	}


	@Override
	public void takeOrder() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void showRegCustomerOffer(int corpId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void showCorpCustomerOffer(int corpId) {
		// TODO Auto-generated method stub
		
	}


	
	

}
