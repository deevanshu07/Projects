package com.info.service;

import java.util.List;

import com.info.model.Employee;
import com.info.model.JsonMap;

public interface HibernateService {

	public Employee authenticateUser(int userId);
	public List<JsonMap> getJsonData();
}
