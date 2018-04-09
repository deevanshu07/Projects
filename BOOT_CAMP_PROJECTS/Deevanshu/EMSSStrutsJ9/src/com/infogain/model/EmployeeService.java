package com.infogain.model;

import java.util.*;
import java.io.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
/**
 * This object performs a variety of league services, such as looking
 * up league objects and creating new ones.
 */
public class EmployeeService {
	static int i=0;
	DataSource ds=null;
	Connection con=null;
	PrintWriter out=null;
	ResultSet rs=null;
	ArrayList<Employee> lsEmployee=new ArrayList<Employee>();
	public EmployeeService(){
	
	}
    public ArrayList<Employee> getEmployee() {
        
    	try
		{
            /*Load the JDBC-ODBC bridge driver*/
			Context ic=new InitialContext();
			ds=(DataSource)ic.lookup("java:OracleDS");
			/*Obtain a Connection object*/
			con=ds.getConnection();
			Statement stmt=null;
			String query=null;
                        /*Create SQL query*/
			query= "select * from EMPLOYEES5";
                        /*Create PreparedStatement object*/
			stmt=con.createStatement();
                        /*Obtain the request parameter and specify it as value of the SQL statement parameter*/
			            /*Execute PreparedStatement*/
			rs=stmt.executeQuery(query);
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				Employee employee=new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getDouble(7), rs.getString(8), rs.getString(9));
				lsEmployee.add(employee);
			}
			
			return lsEmployee;
		}
    	catch(Exception e)
    	{
                   /*Send exception message if any*/
    		System.out.println("error is "+e.toString());
    		return null;
    	}
    }
     
    public Employee createEmployee(int employeeId, String firstName, String lastName,String email,String phoneNumber,java.util.Date hireDate,double salary,String commissionPerct,String department) {
        
    	try
		{
            /*Load the JDBC-ODBC bridge driver*/
			Context ic=new InitialContext();
			ds=(DataSource)ic.lookup("java:OracleDS");
			/*Obtain a Connection object*/
			con=ds.getConnection();
			PreparedStatement pstmt=null;
			String query=null;
                        /*Create SQL query*/
			query= "insert into EMPLOYEES5 values(?,?,?,?,?,?,?,?,?)";
                        /*Create PreparedStatement object*/
			pstmt=con.prepareStatement(query);
                        /*Obtain the request parameter and specify it as value of the SQL statement parameter*/
			pstmt.setInt(1,employeeId);
			pstmt.setString(2,firstName);
			pstmt.setString(3,lastName);
			pstmt.setString(4,email);
			pstmt.setString(5,phoneNumber);
			pstmt.setDate(6,new java.sql.Date(hireDate.getTime()));
			pstmt.setDouble(7,salary);
			pstmt.setString(8,commissionPerct);
			pstmt.setString(9,department);
                        /*Execute PreparedStatement*/
			int count=pstmt.executeUpdate();
			Employee employee=new Employee(employeeId, firstName, lastName, email, phoneNumber, hireDate, salary, commissionPerct, department);
			return employee;
		}
    	catch(Exception e)
    	{
                   /*Send exception message if any*/
    		System.out.println("error is "+e.toString());
    		return null;
    	}
    }
 } // END of EmployeeService class
