

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Serverclass implements Testinterface
{

	
	public Serverclass() 
	{
		super();
		
	}

	
	public static void main(String[] args) 
	{
		if(System.getSecurityManager()==null)
		{
			System.setSecurityManager(new SecurityManager());
		}
		
		String name="Test Server";
		Serverclass server= new Serverclass();
		
		try 
		{
			Remote stub=(Remote)UnicastRemoteObject.exportObject((Remote) server,0);
			Registry registry=LocateRegistry.getRegistry();
			registry.rebind(name, stub);
			System.out.println("Server is Bind......");
		} 
		
		catch (RemoteException e) 
		{
			
			e.printStackTrace();
		}

	}

	@Override
	public String showMessage() throws RemoteException 
	{
		
		return "This Server is Bind";
	}

}
