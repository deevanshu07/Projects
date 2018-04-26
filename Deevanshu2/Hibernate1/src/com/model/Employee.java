package com.model;

public class Employee 
{
	private int id;
	String name;
	String designation;
	String salary;
	
	public Employee( int id,String name, String designation, String salary) 
	{
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	
	public Employee() 
	{
		super();
	}

	public int getId() 
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDesignation() 
	{
		return designation;
	}
	public void setDesignation(String designation) 
	{
		this.designation = designation;
	}
	public String getSalary() 
	{
		return salary;
	}
	
	public void setSalary(String salary) 
	{
		this.salary = salary;
	}

	

}
