import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class EmployeeServer implements NewInterface
{
	public EmployeeServer() 
	{
		// TODO Auto-generated constructor stub
	}
	Employee employee = new Employee();
	@Override
	public String updateEmployee(Employee employee) throws RemoteException
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","hr","hr");		
		
			PreparedStatement pstmt=con.prepareStatement("insert into person values(?,?,?)");
			pstmt.setString(1,employee.getDesignation());
			pstmt.setInt(2,employee.getId());
			pstmt.setString(3,employee.getName());

			int i=pstmt.executeUpdate();
			
			if(i>0)
				return " Employee is registered Successfully";

					}catch(Exception e)
					
					{
						e.printStackTrace();
					}
					
					
					return "error at server";
	}
	
	public static void main(String[] args) 
	{
		if (System.getSecurityManager() == null) 
		{
            System.setSecurityManager(new SecurityManager());
        }
        try 
        {
            String name = "Employeeserver";
            EmployeeServer iserver = new EmployeeServer();
            Remote stub =
                (Remote) UnicastRemoteObject.exportObject(iserver, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("Person Registration Server is binded ");
        } 
        catch (Exception e) 
        {
            System.err.println("Engine exception:");
            e.printStackTrace();
        }
    }
}
	

