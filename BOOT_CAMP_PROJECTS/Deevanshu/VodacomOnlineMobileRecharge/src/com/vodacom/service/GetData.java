package com.vodacom.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.vodacom.model.Plan;

public class GetData {
	//this method returns list of plans from database
	public ArrayList<Plan> getPlan()
	{
		ArrayList<Plan> planList= new ArrayList<Plan>();
		Context ctx;
		try {
			ctx = new  InitialContext();
		
		 DataSource ds=(DataSource)ctx.lookup("java:OracleDS");
			Connection con=ds.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from plan");
			while(rs.next())
			{
				planList.add(new Plan(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}
			
			
		 } catch (Exception e) {
			System.out.println("Error in connection with Database  :"+e.getMessage());
			
		}
		return planList;
	}

}
