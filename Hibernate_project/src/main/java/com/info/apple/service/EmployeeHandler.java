package com.info.apple.service;

import java.util.List;

import com.info.apple.model.Employee;

public interface EmployeeHandler {

	public List<Employee> getAllEmployees();
	public int saveEmployee();
}
