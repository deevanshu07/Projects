package com.info.apple.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.info.apple.model.Employee;

public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;      
	}

	 public int saveEmployee(Employee e){  
	        String query="insert into employee values('"+e.getId()+"','"+e.getName()+"','"+e.getSalary()+"')";  
	        return jdbcTemplate.update(query);  
	    }
}
