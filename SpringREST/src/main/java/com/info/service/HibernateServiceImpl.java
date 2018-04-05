package com.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.dao.HibernateDAO;
import com.info.model.Employee;

@Service("HibernateService")
public class HibernateServiceImpl implements HibernateService {

	@Autowired
	HibernateDAO dao;
	
	@Override
	public Employee getEmployeebyId(int userId) {
		// TODO Auto-generated method stub
		return dao.findbyId(userId);
	}

	@Override
	public void addEmployee(Employee obj) {
		// TODO Auto-generated method stub
		dao.saveEmployee(obj);
		
	}

}
