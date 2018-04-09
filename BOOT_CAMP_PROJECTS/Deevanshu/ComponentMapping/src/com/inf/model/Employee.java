package com.inf.model;


public class Employee extends Name {

	private int id;
	private String designation;
	private int salary;
	private Name name;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Employee()
	{
		super();
	}

	public Name getName() {
		return name;
	}





	public void setName(Name name) {
		this.name = name;
	}





	public Employee(Name name, String designation, int salary) 
	{
		super();
		this.name=name;
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
