package com.soft.ejb;

import java.io.Serializable;
import com.soft.ejb.*;

import javax.persistence.*;
@SuppressWarnings("unused")
@Entity
@Table(name="emp123")
public class Employee implements Serializable
{
	@Id
	@GeneratedValue
	int empId;
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

	public String getEmpLocation() 
	{
		return empLocation;
	}

	public void setEmpLocation(String empLocation) 
	{
		this.empLocation = empLocation;
	}

	String empName;
	String empLocation;
	
	public Employee() 
	{
		super();
	}
	
	@Override
	public String toString() 
	{
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empLocation=" + empLocation + "]";
	}
	
	
	
	

}
