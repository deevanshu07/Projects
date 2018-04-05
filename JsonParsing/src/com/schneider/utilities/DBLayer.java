package com.schneider.utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBLayer {

	Connection con = null;
	
	private final String avgQuery="select round(AVG(SalesAmount) ,2) as SalesAmount	from Reportdetail  where lower(producttype) like '%?%' and to_char(SalesDate, 'Q')='?'";
	
		
	

	public Connection getDBConnection() throws SQLException {	   	   
	    
	    try {
	      
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      System.out.println("Driver Loaded......");
	      if(con==null)
	    	{
	    	  con = DriverManager.getConnection("jdbc:oracle:thin:@bigdata1vm1:1521:orcl","SolrReporting","admin123!");
	    	}
	    
	      if(con!=null)
	      {
	    	  System.out.println("connection successful");
	      }
	      else
	    	  System.out.println("connection not successful");
	     
	    } catch (Exception ex) 
	    {
	      ex.printStackTrace();
	    }
		return con;
	  }
	
	
	public void closeDBConnection(Connection con)
	{
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void closeStatementResultSet(Statement stmt,ResultSet rs )
	{
		if(stmt!=null)
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public float getRevenueLastQuarter(String product) 
	{
		String tempProduct="";
		float result=0;
		PreparedStatement stmt =null;
		ResultSet rs =null;
		String sql = "";
		Map<String,String> map=new HashMap<String,String>();
		map.put("1", "JAN");
		map.put("2", "FEB");
		map.put("3", "MAR");
		map.put("4", "APR");
		map.put("5", "MAY");
		map.put("6", "JUN");
		map.put("7", "JUL");
		map.put("8", "AUG");
		map.put("9", "SEP");
		map.put("10", "OCT");
		map.put("11", "NOV");
		map.put("12", "DEC");
		
		
		try{
		if(product !=null && product.contains(" ")){
			tempProduct="ProductSubType";
		}
		else
		{
			tempProduct = "Producttype";
		}
		sql = "select round(SUM(SalesAmount) ,2) as SalesAmount from Reportdetail  where to_char(SalesDate, 'Q')='4'";
		
		System.out.println(sql);
		
		con = getDBConnection();
		
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next())
		{
			result = rs.getFloat("SalesAmount");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			closeDBConnection(con);
		}
		return result;
	}
	public float getRevenue(String product, int i)
	{
		String tempProduct="";
		float result=0;
		PreparedStatement stmt =null;
		ResultSet rs =null;
		String sql = "";
		Map<String,String> map=new HashMap<String,String>();
		map.put("1", "JAN");
		map.put("2", "FEB");
		map.put("3", "MAR");
		map.put("4", "APR");
		map.put("5", "MAY");
		map.put("6", "JUN");
		map.put("7", "JUL");
		map.put("8", "AUG");
		map.put("9", "SEP");
		map.put("10", "OCT");
		map.put("11", "NOV");
		map.put("12", "DEC");
		
		
		try{
		if(product !=null && product.contains(" ")){
			tempProduct="ProductSubType";
		}
		else
		{
			tempProduct = "Producttype";
		}
		if(i == 1)
			sql = "select round(SUM(SalesAmount) ,2) as SalesAmount from Reportdetail  where to_char(SalesDate, 'Q')='4' and lower(producttype) like '%laptop%'";
		else if(i == 2)
			sql = "select round(SUM(SalesAmount) ,2) as SalesAmount from Reportdetail  where to_char(SalesDate, 'Q')='4' and lower(producttype) like '%printer%'";
		else if(i == 3)
			sql = "select round(SUM(SalesAmount) ,2) as SalesAmount from Reportdetail  where to_char(SalesDate, 'Q')='4' and lower(producttype) like '%scanner%'";
		
		System.out.println(sql);
		
		con = getDBConnection();
		
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next())
		{
			result = rs.getFloat("SalesAmount");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			closeDBConnection(con);
		}
		return result;
	}
	
	public float getAverage(String filterType,String filterValue,String product) 
	{
		String tempProduct="";
		float result=0;
		PreparedStatement stmt =null;
		ResultSet rs =null;
		String sql = "";
		Map<String,String> map=new HashMap<String,String>();
		map.put("1", "JAN");
		map.put("2", "FEB");
		map.put("3", "MAR");
		map.put("4", "APR");
		map.put("5", "MAY");
		map.put("6", "JUN");
		map.put("7", "JUL");
		map.put("8", "AUG");
		map.put("9", "SEP");
		map.put("10", "OCT");
		map.put("11", "NOV");
		map.put("12", "DEC");
		
		
		try{
		if(product !=null && product.contains(" ")){
			tempProduct="ProductSubType";
		}
		else
		{
			tempProduct = "Producttype";
		}
		if("qtr".equalsIgnoreCase(filterType))
		{	
			sql = "select round(AVG(SalesAmount) ,2) as SalesAmount	from Reportdetail  where lower("+tempProduct+") like '%"+product+"%' "
				+ "and to_char(SalesDate, 'Q')='"+filterValue+"'";
		}else if("mon".equalsIgnoreCase(filterType))
		{
			filterValue = map.get(filterValue);
			sql = "select round(AVG(SalesAmount) ,2) as SalesAmount	from Reportdetail  where lower("+tempProduct+") like '%"+product+"%' "
					+ "and to_char(SalesDate, 'MON')='"+filterValue+"'";
		}
		else if ("yyyy".equalsIgnoreCase(filterType))
		{
			sql = "select round(AVG(SalesAmount) ,2) as SalesAmount	from Reportdetail  where lower("+tempProduct+") like '%"+product+"%' "
					+ "and to_char(SalesDate, 'YYYY')='"+filterValue+"'";
		}
		
		System.out.println(sql);
		
		con = getDBConnection();
		
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next())
		{
			result = rs.getFloat("SalesAmount");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			closeDBConnection(con);
		}
		return result;
	}
	public int getCount(String filterType,String filterValue,String product) 
	{
		String tempProduct="";
		int result=0;
		PreparedStatement stmt =null;
		ResultSet rs =null;
		String sql = "";
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("1", "JAN");
		map.put("2", "FEB");
		map.put("3", "MAR");
		map.put("4", "APR");
		map.put("5", "MAY");
		map.put("6", "JUN");
		map.put("7", "JUL");
		map.put("8", "AUG");
		map.put("9", "SEP");
		map.put("10", "OCT");
		map.put("11", "NOV");
		map.put("12", "DEC");
		
		try{
		if(product !=null && product.contains(" ")){
			tempProduct="ProductSubType";
		}
		else
		{
			tempProduct = "Producttype";
		}
		if("qtr".equalsIgnoreCase(filterType))
		{
			sql = "select count(*) countN from Reportdetail where lower("+tempProduct+") like '%"+product+"%' and to_char(SalesDate, 'Q')='"+filterValue+"'";
		}
		if("mon".equalsIgnoreCase(filterType))
		{
			filterValue = map.get(filterValue);
			sql = "select count(*) countN from Reportdetail where lower("+tempProduct+") like '%"+product+"%' and to_char(SalesDate, 'MON')='"+filterValue+"'";
		}
		if("yyyy".equalsIgnoreCase(filterType))
		{
			sql = "select count(*) countN from Reportdetail where lower("+tempProduct+") like '%"+product+"%' and to_char(SalesDate, 'YYYY')='"+filterValue+"'";
		}
		
		System.out.println(sql);
		
		con = getDBConnection();
		
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next())
		{
			result = rs.getInt("countN");
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			closeDBConnection(con);
		}
		return result;
	}
	
		
	
	
}
