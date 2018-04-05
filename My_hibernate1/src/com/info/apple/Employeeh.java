package com.info.apple;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="info_employee")
public class Employeeh  extends Person{
	String job;	
	int salary;
	
	
	
	public String getJob() {
		return job;
	}
	public Employeeh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employeeh(String name,String job,int salary) {
		super(name);
		this.job=job;
		this.salary=salary;
		
		// TODO Auto-generated constructor stub
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}


}
