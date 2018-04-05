package com.info.apple.service;

import java.util.List;

import com.info.apple.dao.EmployeeDao;
import com.info.apple.model.Employee;

public class EmployeeService implements EmployeeHandler {

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveEmployee() {
		// TODO Auto-generated method stub
		EmployeeDao dao= new EmployeeDao();
		int result=dao.saveEmployee(new Employee(101349, "Deevanshu", 50000));
		return result;
	}

}
