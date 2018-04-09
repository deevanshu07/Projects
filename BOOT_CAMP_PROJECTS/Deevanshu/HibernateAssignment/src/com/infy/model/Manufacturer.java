package com.infy.model;

public class Manufacturer 
{
	
	private int manf_id;
	private String manf_name;
	
	public Manufacturer() 
	{
		
		
	}
	public Manufacturer(int manf_id, String manf_name)
	{
		super();
		this.manf_id = manf_id;
		this.manf_name = manf_name;
	}
	
	public int getManf_id() 
	{
		return manf_id;
	}
	
	public String getManf_name() 
	{
		return manf_name;
	}
	
	public void setManf_id(int manf_id) 
	{
		this.manf_id = manf_id;
	}
	
	public void setManf_name(String manf_name) 
	{
		this.manf_name = manf_name;
	}


}
