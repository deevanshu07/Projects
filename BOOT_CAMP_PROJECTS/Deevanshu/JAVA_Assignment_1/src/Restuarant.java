import java.util.Scanner;


public class Restuarant 
{
	void showMenu()
	{
		//ItemClass item=new ItemClass();
		MenuClass mn=new MenuClass();
		mn.display();
	}
	void takeOrder()
	{
		Order order= new Order();
		int c=0;
		System.out.println("Enter the Details of Order");
		int ch;
		String str, str1;
		int id;
		Scanner input= new Scanner(System.in);
		do
		{
			System.out.println("Enter any one of the following to place the Order");
			System.out.println("1.Place Order Item Id");
			System.out.println("2. Item Name");
			ch=Integer.parseInt(input.next());
			switch(ch)
			{
			case 1: System.out.println("Enter the Item id");
			        id= Integer.parseInt(input.next());
			        order.byid(id);
			        break;
			        
			case 2: System.out.println("Enter the Item Name");
					str=input.next();
					order.byname(str);
					break;
					
			case 3: System.out.println("Press for Main Menu");
				break;
			
			
		
			
			
		
	}
		System.out.println("Press 1 to enter more");
			c=input.nextInt();
			
			if(c==1)
			continue;
				
}
while(ch!=1 && ch!=2 || c==1);
		
		
	}
	void checkStatus(int orderId)
	{
		Queue obj = new Queue();
		obj.get(orderId);
		
		
	}
	void showRegCustomerOffer(int corpId)
	{
		
	}
	void showCorpCustomerOffer(int corpId)
	{
		
	}
	
	public static void main(String[] args) 
	{
		Restuarant r=new Restuarant();
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
					Restuarant r1= new Restuarant();
					r1.showMenu();
					break;
				case 2:
					Restuarant r2= new Restuarant();
					r2.takeOrder();
					break;
				case 3:
					System.out.println("Enter OrderId=");
					int oId=input.nextInt();
					r.checkStatus(oId);
					break;
				case 4:
					System.out.println("Enter CorpId");
					int cId=input.nextInt();
					r.showRegCustomerOffer(cId);
					break;
				case 5:
					System.out.println("Enter CorpId");
					int cId2=input.nextInt();
					r.showCorpCustomerOffer(cId2);
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

}
