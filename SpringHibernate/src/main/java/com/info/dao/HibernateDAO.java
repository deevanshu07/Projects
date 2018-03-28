package com.info.dao;

import com.info.model.Employee;

public interface HibernateDAO {

	public Employee findEmployee(int userId);
	public void saveEmployee(Employee employee);
}
