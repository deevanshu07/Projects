package com.infogain.model;

public class Employee {

	private int id;
	private String name;
	
	public Employee(String name, String designation, int salary) 
	{
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	private String designation;
	private int salary;

	public Employee()
	{
		
	}
	public Employee(int id, String name, String designation, int salary) 
	{
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	public String getDesignation() 
	{
		return designation;
	}

	public int getId() 
	{
		return id;
	}

	public String getName() 
	{
		return name;
	}

	public int getSalary() 
	{
		return salary;
	}

	public void setDesignation(String designation) 
	{
		this.designation = designation;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public void setSalary(int salary) 
	{
		this.salary = salary;
	}

}
