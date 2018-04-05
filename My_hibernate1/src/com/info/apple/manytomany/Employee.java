package com.info.apple.manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ss_employee")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "employeeId")
	private int employeeId;
	private String name;
	private String job;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_previledges", joinColumns = { @JoinColumn(name = "employeeId") }, inverseJoinColumns = { @JoinColumn(name = "previledgeId") })
	Set<Previledge> previledges;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String job) {
		super();
		this.name = name;
		this.job = job;

	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getJob() {
		return job;
	}

	public String getName() {
		return name;
	}

	public Set<Previledge> getPreviledges() {
		return previledges;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPreviledges(Set<Previledge> previledges) {
		this.previledges = previledges;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name
				+ ", job=" + job;
	}

}
