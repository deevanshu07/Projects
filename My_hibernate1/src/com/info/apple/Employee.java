package com.info.apple;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "info_emp",
uniqueConstraints= @UniqueConstraint(columnNames={"NAME"}, name="PK_UNIQUE_KEY_CONSTRAINT"))
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	

	@Column(name="NAME")
	private String name;
	
	private int salary;
	private String department;
	public void setDepartment(String department){
		this.department=department;
	}

	public String getDepartment(){
		return department;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int salary) {
		super();

		this.name = name;
		this.salary = salary;
	}

	public Employee(int id,String name, int salary, String department) {
		super();

		this.id=id;
		this.name = name;
		this.department=department;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", department=" + department + "]\n";
	}

	public int getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
