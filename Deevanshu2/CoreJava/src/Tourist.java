import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


//Class for obtaining necessary information about the tickets and tourists

public class Tourist 
{
	static ArrayList<Ticket> addTicket = new ArrayList<Ticket>();
	
	
	Date bookingDate = new Date();
	Booking booking = new Booking();
	void bookTicket()
	{
		Tourist t1 = new Tourist();
		int numberOfTickets;
		int id,age;
		String name,origin,mobileNumber;
		int flag=0;
		
		String Date;
		Scanner input = new Scanner(System.in);
		System.out.println("How Many Tickets You Want to book");
		try{
			
		numberOfTickets=input.nextInt();
		
		
		if(numberOfTickets>10)
		{
			System.out.println("You can't book "+numberOfTickets+" tickets simultaneously");
			System.out.println("Try Once Again");
			System.out.println();
			flag=1;
		}
		
		
		else if(flag==0)
		{
		
		
		System.out.println("Please Provide the following Information to book the Ticket");
		
		System.out.println("Enter your id=");
		id= input.nextInt();
		System.out.println("Enter your Name=");
		name=input.next();
		System.out.println("Enter your Origin(I for Indian or F for Foriegner)=");
		origin=input.next();
		System.out.println("Enter your Age=");
		age=input.nextInt();
		System.out.println("Enter your Mobile Number=");
		mobileNumber=input.next();
		
		System.out.println("Enter The booking Date");
		Date = input.next();
		//Date=input.next();
	
		Ticket ticket = new Ticket(id,name,origin,age,mobileNumber,bookingDate);
	
		addTicket.add(ticket);
		booking.bookTicket(ticket,numberOfTickets);
		}
		}
		catch(Exception e)
		{
			BookingException Except = new BookingException();
			Except.throwException();
		}
			 
	}


	public static void main(String[] args)
	{
		
		int choice=0;
		System.out.println("hello");
		String choice2;
		
		do
		{
		System.out.println("Welcome to the Ticket booking Counter");
		System.out.println("Select from the following Choices");
		System.out.println("1. Book Ticket");
		System.out.println("2. View Visitors");
		Scanner input = new Scanner(System.in);
		choice= input.nextInt();
		
		switch(choice)
		{
		case 1:Tourist t = new Tourist(); 
			   t.bookTicket();
			   break;
			   
		case 2: System.out.println("Please Enter the Admins Password to view The Information");
					int password;
					password=input.nextInt();
					if(password==1234)
					{
					Booking viewVisitors = new Booking();
					viewVisitors.viewVisitors();
					}
					else 
						System.out.println("your Password is incorrect! Try again");
					break;
				default: System.out.println("Wrong Choice! Try Again");
							System.out.println();
				
		}
		System.out.println("Press Y to Continue and N to exit");
		choice2=input.next();
		

	}while(choice!='Y' || choice !='N' || choice !='n'|| choice!='y');

}
}