package com.info.service;

import java.util.List;

import com.info.model.Employee;

public interface EmployeeHandler {
	public List<Employee> findById(String id);

}
