package com.soft.ejb;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;



/**
 * Session Bean implementation class LoginBean
 */
@Stateless
public class LoginBean implements LoginBeanRemote, LoginBeanLocal {

    /**
     * Default constructor. 
     */
    public LoginBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Resource(mappedName="java:OracleDS")
    DataSource ds;
    public boolean validate(String username,String password)
	{
    	/*if(username.equals(password))
    	{
    		return true;
    	}
    	else
    		return false;*/
    	
    	try
    	{
    		
    		String sql="select * from user_login where username=?"; 
    	
    	Connection con= ds.getConnection();
    	PreparedStatement pstmt=con.prepareStatement(sql);
    	pstmt.setString(1,username);
   
    	ResultSet result=pstmt.executeQuery();
    	if(result.next())
    	{
    		return true;
    	}
    	
    
    	else
    		return false;
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}	
	return true;
}
}