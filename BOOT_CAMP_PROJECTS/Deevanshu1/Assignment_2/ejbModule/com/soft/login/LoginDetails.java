package com.soft.login;

import java.io.Serializable;

import javax.persistence.*;




@Entity
@Table(name="users")
public class LoginDetails implements Serializable
{
	@Id
	@GeneratedValue
	private String userId;
	private String name;
	private String password;
	private String userType;
	private String address;
	private String contactNo;
	
	
	public LoginDetails() 
	{
		super();
		
	}


	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getUserId() 
	{
		return userId;
	}
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getUserType() 
	{
		return userType;
	}
	public void setUserType(String userType) 
	{
		this.userType = userType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	public String getContactNo() 
	{
		return contactNo;
	}
	public void setContactNo(String contactNo) 
	{
		this.contactNo = contactNo;
	}

}