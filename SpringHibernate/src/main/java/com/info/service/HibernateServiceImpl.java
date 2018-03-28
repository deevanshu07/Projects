package com.info.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.info.dao.HibernateDAO;
import com.info.model.Employee;
import com.info.model.JsonMap;

@Service("hibernateService")
public class HibernateServiceImpl implements HibernateService {

	@Autowired
	HibernateDAO hibernateDAO;

	@Override
	public Employee authenticateUser(int userId) {
		// TODO Auto-generated method stub
		return hibernateDAO.findEmployee(userId);
	}

	@Override
	public List<JsonMap> getJsonData() {
		// TODO Auto-generated method stub
		RestTemplate rest = new RestTemplate();
		String mappedString = rest.getForObject(
				"https://restcountries.eu/rest/v1/all", String.class);
		JSONArray jsonArray = new JSONArray(mappedString);
		List<JsonMap> list = new ArrayList<JsonMap>();
		String str = "";
		Gson gson = new Gson();
		JsonMap map;
		for (int i = 0; i < jsonArray.length(); i++) {
			map = gson.fromJson(jsonArray.get(i).toString(), JsonMap.class);
			list.add(map);
		}

		return list;
	}

}
