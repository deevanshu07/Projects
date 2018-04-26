import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class EmployeeClient
{
	public static void main(String[] args) 
	{
		if (System.getSecurityManager() == null)
		{
            System.setSecurityManager(new SecurityManager());
        }
        try
        {
        		String name = "Employeeserver";
        		Registry registry = LocateRegistry.getRegistry("127.0.0.1");
        		NewInterface comp = ( NewInterface) registry.lookup(name);
        		Employee employee=new Employee(args[0],Integer.parseInt(args[1]),args[2]);
        		comp.updateEmployee(employee);
        }
        catch (Exception e) 
        {
            System.err.println("Client ex:");
            e.printStackTrace();
        }
		
	}

}
