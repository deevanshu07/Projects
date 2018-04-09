package com.infy.model.map;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Employee {
	private int employeeId;
	private String ename;
	private Map<String,String> benefit;


	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Map<String, String> getBenefit() {
		return benefit;
	}
	public void setBenefit(Map<String, String> benefit) {
		this.benefit = benefit;
	}
}
	
	
	

	