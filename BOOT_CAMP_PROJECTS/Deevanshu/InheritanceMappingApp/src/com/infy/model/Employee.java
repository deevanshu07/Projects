package com.infy.model;

public class Employee  extends Person{
	
	private String designation;
	private int salary;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
		
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	


	public Employee(String name, String designation, int salary) {
		super(name);
		
		this.designation = designation;
		this.salary = salary;
	}

}
