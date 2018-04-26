import java.util.*;


//class for Booking Tickets

public class Booking implements Booking_Information
{
	
	
	
	@Override
	public void bookTicket(Ticket ticket, int num) 
	{
		
		 if(ticket.getVisitorOrigin().equalsIgnoreCase("i"))
		 {
			 System.out.println("Indian Tourist ");
			 System.out.println("Please pay rupees "+(50*num));
			 System.out.println("And Your Tourist Id ="+ticket.getId());
			 
		 }
		 if(ticket.getVisitorOrigin().equalsIgnoreCase("F"))
		 {
			 System.out.println("Foreigner Tourist ");
			 System.out.println("Please pay rupees "+(500*num));
			 System.out.println("And Your Tourist Id ="+ticket.getId());
			 
		 }

		System.out.println("Thanks for Coming");
		
		
		
		
	}

	@Override
	public void viewVisitors() 
	{
		Tourist t = new Tourist();
		System.out.println("The Following Customers are in the List");
		System.out.println(t.addTicket);
		
	}

	
}
