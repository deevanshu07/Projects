package com.model;

public class person extends Employee
{

	private String personName;
	private String personAge;
	
	public person(String personName, String personAge) 
	{
		super();
		this.personName = personName;
		this.personAge = personAge;
	}

	public person( int id,String name, String designation, String salary) 
	{
		super(id, name, designation, salary);
		
	}
	
	public person() 
	{
		super();
		
	}
	public String getPersonName() 
	{
		return personName;
	}
	public void setPersonName(String personName)
	{
		this.personName = personName;
	}
	public String getPersonAge()
	{
		return personAge;
	}
	public void setPersonAge(String personAge) 
	{
		this.personAge = personAge;
	}

}
