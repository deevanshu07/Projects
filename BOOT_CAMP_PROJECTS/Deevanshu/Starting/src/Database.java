import java.sql.*;
import java.util.Scanner;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Database 
{

	public static void main(String args[])
	{
		
		
		//ArrayList<Departments> departments= new ArrayList<Departments>();
		 
		 
	String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String user="hr";
	String passwd="hr";
	
	
	try{
		String sql="select * from jobs";
		//String sql1="select * from employees";
		//String sql2="select * from departments";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
Connection con=DriverManager.getConnection(url,user,passwd);

Statement st= con.createStatement();
//Statement stmt= con.createStatement();

//PreparedStatement stmt=con.prepareStatement(sql);


ResultSet result = st.executeQuery(sql);
//ResultSet result1 = stmt.executeQuery(sql1);
//ResultSet result2 = st.executeQuery(sql2);

/*//ResultSetMetaData rsmd =result.getMetaData();

for(int i=1;i<=rsmd.getColumnCount();i++)
{
System.out.println(rsmd.getColumnName(i)+"\t"+rsmd.getColumnTypeName(i));

}*/

while(result.next())
{
	System.out.println(result.getString(1));
}

/*while(result1.next())
{
	System.out.println(result1.getInt(1));
}
*/
/*//while(result2.next())
{
	System.out.println(result2.getInt(1));
}*/
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	

	
	

}

}

	




/*
public class Database {
	
	public static void main(String[] args) {
		
		String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user="hr";
		String passwd="hr";
		
		
		try{
			String sql="select * from "+args[0];
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
Connection con=DriverManager.getConnection(url,user,passwd);

Statement st= con.createStatement();
//PreparedStatement stmt=con.prepareStatement(sql);


ResultSet result = st.executeQuery(sql);

ResultSetMetaData rsmd =result.getMetaData();

for(int i=1;i<=rsmd.getColumnCount();i++)
{
	System.out.println(rsmd.getColumnName(i)+"\t"+rsmd.getColumnTypeName(i));
	
}
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		

	}

}



*/