package com.infogain.model;

public class Employee extends Person {

	
	private String designation;
	private int salary;
	private String name;


	public Employee()
	{
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public Employee(String name, String designation, int salary) 
	{
		super(name);
		
		this.designation = designation;
		this.salary = salary;
	}

	public String getDesignation() 
	{
		return designation;
	}


	public int getSalary() 
	{
		return salary;
	}

	public void setDesignation(String designation) 
	{
		this.designation = designation;
	}

	


	public void setSalary(int salary) 
	{
		this.salary = salary;
	}

}
