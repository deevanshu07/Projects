import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class Order {
	
	public static void main(String[] args) {
		
		String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user="hr";
		String passwd="hr";
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
Connection con=DriverManager.getConnection(url,user,passwd);

Statement stmt=con.createStatement();

String query="select * from employees where department_id='10'";

			
	ResultSet result=stmt.executeQuery(query);	
			
			while(result.next())
			{
				System.out.println(result.getString(1)+"\t"+result.getString(2));
				
			}
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		

	}

}

