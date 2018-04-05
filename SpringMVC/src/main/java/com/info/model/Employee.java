package com.info.model;

import java.util.ArrayList;
import java.util.Date;

import javax.inject.Singleton;

import org.junit.runners.Parameterized.Parameters;

public class Employee {
	private String employeeName;
	private String employeeId;
	private ArrayList<String> employeeSkills;
	private Date employeeDOB;
	private long employeeMobile;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getEmployeeDOB() {
		return employeeDOB;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public long getEmployeeMobile() {
		return employeeMobile;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public ArrayList<String> getEmployeeSkills() {
		return employeeSkills;
	}

	public void setEmployeeDOB(Date employeeDOB) {
		this.employeeDOB = employeeDOB;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeMobile(long employeeMobile) {
		this.employeeMobile = employeeMobile;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setEmployeeSkills(ArrayList<String> employeeSkills) {
		this.employeeSkills = employeeSkills;
	}

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeId="
				+ employeeId + ", employeeSkills=" + employeeSkills
				+ ", employeeDOB=" + employeeDOB + ", employeeMobile="
				+ employeeMobile + "]";
	}

}
