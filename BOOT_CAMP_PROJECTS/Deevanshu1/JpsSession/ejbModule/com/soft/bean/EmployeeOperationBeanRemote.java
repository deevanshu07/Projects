package com.soft.bean;

import java.util.ArrayList;

import javax.ejb.Remote;

import com.soft.ejb.Employee;

@Remote
public interface EmployeeOperationBeanRemote 
{
	public int addEmployee(Employee emp) ;
	public Employee getEmployee(int empId);
	@SuppressWarnings("rawtypes")
	public ArrayList getAllEmployee();
	public int removeEmployee(int empId); 

}
