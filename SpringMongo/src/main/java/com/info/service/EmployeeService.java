package com.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.model.Employee;
import com.info.repository.EmployeeRepository;

@Service("emplyeeService")
public class EmployeeService implements EmployeeHandler{

@Autowired
EmployeeRepository employee;
	
	@Override
	public List<Employee> findById(String id) {
		// TODO Auto-generated method stub
		return employee.findByid(id);
	}

}
