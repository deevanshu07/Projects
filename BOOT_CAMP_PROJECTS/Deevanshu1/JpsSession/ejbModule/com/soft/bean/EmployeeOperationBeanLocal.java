package com.soft.bean;

import java.util.ArrayList;

import javax.ejb.Local;

import com.soft.ejb.Employee;

@Local
public interface EmployeeOperationBeanLocal 
{
	public int addEmployee(Employee emp);
	public Employee getEmployee(int empId);
	@SuppressWarnings("rawtypes")
	public ArrayList getAllEmployee();
	public int removeEmployee(int empId); 

}
