

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientClass {

	
	public static void main(String[] args) 
	{
		if(System.getSecurityManager()==null)
		{
			System.setSecurityManager(new SecurityManager());
		}

		String name="Test Server";
		try 
		{
			Registry registry=LocateRegistry.getRegistry(args[0]);
			Testinterface test=(Testinterface)registry.lookup(name);
			String s1=test.showMessage();
			System.out.println(s1);
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
	}

}
