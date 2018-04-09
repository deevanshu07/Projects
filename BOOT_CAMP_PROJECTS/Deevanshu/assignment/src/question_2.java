import java.lang.*;
import java.util.Scanner;





public class question_2
{
	public static void main(String[] args)
	{
		
		
		Item itemtype[] = new Item[5];
		
		
		
		int ch;
	
	    
	    Scanner sc = new Scanner(System.in);
		
		System.out.println("Restuarent System");
		
		do
		{
		 System.out.println(" 1.Show Menu");
			
		        
		 System.out.println("2.Take order");
		 
		 System.out.println("3.Check Status");
		
		 System.out.println("4.Show Regular Customer offer");
		 
		 System.out.println("5.Show Corporation Customer offer");
		 
		
		  ch = Integer.parseInt(sc.next());
		
		  switch(ch)
		  { 
		  case 1: System.out.println("Sample Items are");
			  for(int i=0;i<4;i++)
			   System.out.println( itemtype[i].display());
		       break;
			  
		default: System.out.println("Nothing");
		  }}
		
		  while(ch!=0);
		
		
		
		
	}
	}


