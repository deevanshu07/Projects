package com.info.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee1")
public class Employee {

	@Id
	private int userId;
	private String password;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public int getUserId() {
		return userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Employee [userId=" + userId + ", password=" + password + "]";
	}
}
