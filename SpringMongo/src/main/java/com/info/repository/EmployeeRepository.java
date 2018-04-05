package com.info.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.info.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> ,EmployeeCustmRepository{

	public List<Employee> findByid(String id);
}
