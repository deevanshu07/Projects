import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;


public class RegsiterServer implements Register{

	public RegsiterServer()
	{
		 super();
	}
	
	
	@Override
	public String addPerson(Person person) throws RemoteException {
		// TODO Auto-generated method stub
				try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","hr","hr");	
PreparedStatement stat=con.prepareStatement("Insert into test values(?,?,?)");
PreparedStatement pstmt=con.prepareStatement("insert into person values(?,?,?)");
pstmt.setString(1,person.getName());
pstmt.setString(2,person.getAge());
pstmt.setString(3,person.getLocation());

int i=pstmt.executeUpdate();
if(i>0)
	return " Person is registered Successfully";

		}catch(Exception e)
		
		{
			e.printStackTrace();
		}
		
		
		return "error at server";
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "personserver";
            RegsiterServer iserver = new RegsiterServer();
            Remote stub =
                (Remote) UnicastRemoteObject.exportObject(iserver, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("Person Registration Server is binded ");
        } catch (Exception e) {
            System.err.println("Engine exception:");
            e.printStackTrace();
        }
    }
		
		
	}

	


