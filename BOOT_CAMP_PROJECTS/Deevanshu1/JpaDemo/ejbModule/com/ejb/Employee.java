package com.ejb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp_12")
public class Employee implements Serializable
{

	@Id
	@GeneratedValue
	private int empId;
	private String empName;
	
	public Employee(int empId, String empName) 
	{
		super();
		this.empId = empId;
		this.empName = empName;
	}
	public Employee() 
	{
		super();	
	}
	public int getEmpId() 
	{
		return empId;
	}
	public void setEmpId(int empId)
	{
		this.empId = empId;
	}
	public String getEmpName() 
	{
		return empName;
	}
	public void setEmpName(String empName) 
	{
		this.empName = empName;
	}
	


}
