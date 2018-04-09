import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


 class Jobsmap implements Serializable
{

	public static void main(String args[])
	{
		
		
		Map<Integer, Jobs> jobsmap		   		= new HashMap<Integer, Jobs>();
		Map<Integer,Employees>employeesmap 		= new HashMap<Integer, Employees>();
		Map<Integer,Departments>departmentsmap	= new HashMap<Integer, Departments>();
		
		
		
		 
	String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String user="hr";
	String passwd="hr";
	
	int i=0,j=0,z=0;
	try{
		
		
	
		
		
		String sql="select * from jobs";
		String sql1="select * from employees";
		String sql2="select * from departments";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
Connection con=DriverManager.getConnection(url,user,passwd);
Statement stmt= con.createStatement();
Statement stmt1= con.createStatement();
Statement stmt2= con.createStatement();

ResultSet result = stmt.executeQuery(sql);
ResultSet result1 = stmt1.executeQuery(sql1);
ResultSet result2 = stmt2.executeQuery(sql2);


while(result.next())
{
	Jobs job = new Jobs(result.getString(1),result.getString(2),result.getInt(3),result.getInt(4));
	jobsmap.put(i,job);
	i++;
	
	
	 
}

while(result1.next())
{
	Employees employees = new Employees(result1.getInt(1),result1.getString(2),result1.getString(3),result1.getString(4),
										result1.getString(5),result1.getDate(6),result1.getString(7),result1.getInt(8),
										result1.getInt(9),result1.getInt(10),result1.getInt(11));
	employeesmap.put(z,employees);
	z++;
	
	
}


while(result2.next())
{
	Departments departments= new Departments(result2.getInt(1),result2.getString(2),result2.getInt(3),result2.getInt(4));
	departmentsmap.put(j,departments);
	j++;
}

System.out.println("Helloo");

Map <Integer, Map> hrmap = new HashMap<Integer, Map>();


hrmap.put(1, jobsmap);
hrmap.put(2, employeesmap);
hrmap.put(3,departmentsmap);

System.out.println(jobsmap.size());
System.out.println(employeesmap.size());
System.out.println(departmentsmap.size());

System.out.println(hrmap.size());


ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream("C:/Users/DEEVANSHU.MAHAJAN/Desktop/dee.txt"));

out.writeObject(hrmap);
System.out.println("Object Written Succesfully");


ObjectInputStream in = new ObjectInputStream( new FileInputStream("C:/Users/DEEVANSHU.MAHAJAN/Desktop/dee.txt"));

Map<String, Map> Readingmap= new HashMap<String, Map>();

Readingmap.put("List",(Map)in.readObject());
System.out.println(Readingmap);



	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	

}

	
	}



