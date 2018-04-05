package com.info.apple.manytomany;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ss_previledge")
public class Previledge {

	@Id
	@GeneratedValue
	@Column(name = "previledgeId")
	private int previledgeId;
	private String name;

	@ManyToMany(mappedBy = "previledges")
	Set<Employee> employeeSet;

	public Previledge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Previledge(Set<Employee> employeeSet, String name) {
		super();
		this.employeeSet = employeeSet;
		this.name = name;
	}

	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}

	public String getName() {
		return name;
	}

	public int getPreviledgeId() {
		return previledgeId;
	}

	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPreviledgeId(int previledgeId) {
		this.previledgeId = previledgeId;
	}

	@Override
	public String toString() {
		return "Previledge [previledgeId=" + previledgeId + ", employeeSet="
				+ employeeSet + ", name=" + name + "]";
	}

}
