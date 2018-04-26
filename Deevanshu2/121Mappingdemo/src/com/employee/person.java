package com.employee;

public class person extends Employee
{

	String name;
	int age;
	
	
	public person(String name, int age) 
	{
		super();
		this.name = name;
		this.age = age;
	}
	
	public person() 
	{
		super();
	}
	public person(int id, String name, String designation, int salary) 
	{
		super(id, name, designation, salary);
		
	}
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}

}
