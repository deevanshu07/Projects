import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class InsertClient{
	

	
	    public static void main(String args[]) 
	    {
	        if (System.getSecurityManager() == null) 
	        {
	            System.setSecurityManager(new SecurityManager());
	        }
	        try 
	        {
	            String name = "iserver";
	            Registry registry = LocateRegistry.getRegistry(args[0]);
	            Insert comp = (Insert) registry.lookup(name);
	            
	             comp.insert(args[1],args[2],args[3]);
	        } 
	        catch (Exception e) 
	        {
	            System.err.println("Client ex:");
	            e.printStackTrace();
	        }
	    }    
	}



