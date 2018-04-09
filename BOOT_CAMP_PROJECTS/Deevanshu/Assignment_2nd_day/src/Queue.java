import java.util.*;





public class Queue 
{
	
	
	 
	
	
	 static void display(int i)
		{
		 Order order = new Order();
		 
		 Date date = new Date();
			
			MenuClass menu= new MenuClass();
			if(order.order_time.get(i).getDate()>date.getHours()*3600+date.getMinutes()*60+date.getSeconds())
			{
				System.out.println("Item Not Ready! Wait ");
			}
			
			else
			{
				System.out.println("Item Ready");
			}
			
			if(order.tokenNumber==1);
			System.out.println("Item is removed");
		}
		
	static int order1,diff,diff2;

	
	void waitingTime( int i)
{
	
	
		Order order = new Order();
	 
	int j=i;
	
	for( int k=0;k<order.orderCart2.size();k++)
	{
		
		order1=order.orderCart2.get(i).getItemId();
		
		if(order1==j)
		{
			display(j);
			break;
			 
			
			
		}
		
	}
	
	
	
		   
	}	
			
	
}		
	


