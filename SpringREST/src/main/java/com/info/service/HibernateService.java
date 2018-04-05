package com.info.service;

import com.info.model.Employee;


public interface HibernateService {

	public Employee getEmployeebyId(int userId);
	public void addEmployee(Employee obj);
}
