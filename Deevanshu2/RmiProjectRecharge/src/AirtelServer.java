import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class AirtelServer implements Airtel{
	static Connection con1;
	static Connection con;
	static Statement stm;
	static ResultSet result;
	static ArrayList<Long> listOfCustomer = new ArrayList<Long>();
	static
	{
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hr";
		String passwd = "hr";
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, passwd);
			stm = con.createStatement();
			String query ="select * from PrepaidCustomer";
			result = stm.executeQuery(query);
			while(result.next())
			{
				listOfCustomer.add(Long.parseLong(result.getString(1)));
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public AirtelServer(){
		
	}
	@Override
	public String getBalance(PrepaidCustomer newCustomer) throws RemoteException 
	{
		
		try
		{
		for(Long number:listOfCustomer)
		{
		if(number == newCustomer.getOriginatingNumber())
		{
	
	String query = "update PrepaidCustomer set balanceamount=balanceamount-"+""
					+newCustomer.getDurationOfCall()*2+
					"where  originatingnumber="+newCustomer.getOriginatingNumber();
				
	if(stm.executeUpdate(query)>0)
	{
	query = "select balanceamount from prepaidcustomer where originatingnumber="+""+newCustomer.getOriginatingNumber();
	
	result = stm.executeQuery(query);
	while(result.next())
	{
						
		return result.getString(1);
					
	}
				
	}
			
		}
		}
		}
		catch(Exception e){
		}
		return "Invalid Number";
	}
	public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "airtelserver";
            AirtelServer server = new AirtelServer();
            Remote stub =
                (Remote) UnicastRemoteObject.exportObject(server, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("Server bind");
        } catch (Exception e) {
            System.err.println(" exception:");
            e.printStackTrace();
        }
    }
}
