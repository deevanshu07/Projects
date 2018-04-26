import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class InsertServer  implements Insert{
	   InsertServer()
	   {
		   super();
	   }
	    public void insert(String name,String age,String sex)
	    {
	    try 
	    {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=	DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:Xe","hr","hr");
		PreparedStatement stat=con.prepareStatement("Insert into test values(?, ?, ?)");


		stat.setString(1, name);
		stat.setString(2, age);
		stat.setString(3, sex);
        int i= stat.executeUpdate();
			  
				
			} catch (Exception  e) 
			{
				
				e.printStackTrace();
			}
	    	 
	    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "iserver";
            InsertServer iserver = new InsertServer();
            Remote stub =
                (Remote) UnicastRemoteObject.exportObject(iserver, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("iServer bind");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }

	}


