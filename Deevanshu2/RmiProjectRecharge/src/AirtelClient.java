import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AirtelClient 
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		if (System.getSecurityManager() == null) 
		{
			System.setSecurityManager(new SecurityManager());
		}
		try 
		{
			String name = "airtelserver";
			Registry registry = LocateRegistry.getRegistry("127.0.0.1");
			Airtel comp = (Airtel) registry.lookup(name);
			// int s1=comp.deposit(101,1000);
			System.out.println("Enter Mobile No");
			long originatingNumber = scan.nextLong();
			int durationOfCall = scan.nextInt();
			PrepaidCustomer customer = new PrepaidCustomer(originatingNumber,durationOfCall);
			String s1 = comp.getBalance(customer);
			 System.out.println(s1);
		} 
		
		catch (Exception e) 
		{
			System.err.println("Exception is Thrown");
			e.printStackTrace();
		}
	}
}
