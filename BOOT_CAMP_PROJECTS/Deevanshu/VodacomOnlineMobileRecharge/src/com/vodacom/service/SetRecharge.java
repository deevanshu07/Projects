package com.vodacom.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SetRecharge 
{
	//this method enters a new row corresponding to every recharge
	public void enterRecharge(int rechargeId,String mobileNo,int PlanId)
	{
		Context ctx;
		try {
			ctx = new  InitialContext();
		
		
		 DataSource ds=(DataSource)ctx.lookup("java:OracleDS");
			Connection con=ds.getConnection();
			Statement stmt=con.createStatement();
			
			stmt.executeUpdate("Insert into recharge values("+rechargeId+","+mobileNo+","+PlanId+")");
			con.close();
		} catch (Exception e) {
			System.out.println("Error in connection with Database  :"+e.getMessage());
			
		}
		
	}
	
	//this method retrieves the current balance of a particular number
     public int getBalance(String mobileNo)
     {
    		ResultSet rs;
    	 Context ctx;
    	 int balance=0;
		try {
			ctx = new  InitialContext();
		
		
		 DataSource ds=(DataSource)ctx.lookup("java:OracleDS");
			Connection con=ds.getConnection();
			Statement stmt=con.createStatement();
			
			rs=stmt.executeQuery("select Balance from mobile where mobileno="+mobileNo);
			while(rs.next())
			{
			 balance=rs.getInt(1);
			}
			
			return balance;
		} catch (Exception e) {
			System.out.println("Error in connection with Database  :"+e.getMessage());
			return 0;
		}
		
    	 
     }
	
	
	// this method updates the balance of the number
	public void updateBalance(String mobileNo,int balance)
	{
		Context ctx;
		try {
			ctx = new  InitialContext();
		
		
		 DataSource ds=(DataSource)ctx.lookup("java:OracleDS");
			Connection con=ds.getConnection();
			Statement stmt=con.createStatement();
			
			stmt.executeUpdate("update mobile set balance="+balance+" where mobileno="+mobileNo);
			con.close();
		} catch (Exception e) {
			System.out.println("Error in connection with Database  :"+e.getMessage());
			
		}
		
	}
	
	

}
