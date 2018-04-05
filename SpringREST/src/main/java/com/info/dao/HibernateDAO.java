package com.info.dao;

import com.info.model.Employee;

public interface HibernateDAO {

	public Employee findbyId(int userId);
	public void saveEmployee(Employee emp);
}
