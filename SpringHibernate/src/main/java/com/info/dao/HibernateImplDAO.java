package com.info.dao;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.info.model.Employee;

@Repository("hibernateDAO")
public class HibernateImplDAO implements HibernateDAO {

	HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public Employee findEmployee(int userId) {
		// TODO Auto-generated method stub
		Employee emp= template.get(Employee.class, userId);
		System.out.println(emp);
		if(emp!=null){
			return emp;
		}
		
		return null;
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		template.save(employee);
		
	}

}
