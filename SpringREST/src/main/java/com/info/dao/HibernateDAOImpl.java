package com.info.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.info.model.Employee;

@Repository("HibernateDAO")
public class HibernateDAOImpl implements HibernateDAO {

	HibernateTemplate template;
	
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	

	@Override
	public Employee findbyId(int userId) {
		// TODO Auto-generated method stub
		Employee emp=(Employee) template.get(Employee.class, userId);
		return emp;
	}


	@Override
	public void saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		template.save(emp);
		
	}

}
