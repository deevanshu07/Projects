package com.info.model;
public class Employee {  
private String name;
private int id;
private float salary;

public Employee() {
	super();
}

public Employee(String name, int id, float salary) {
	super();
	this.name = name;
	this.id = id;
	this.salary = salary;
}

public int getId() {
	return id;
}

public String getName() {  
    return name;  
}

public float getSalary() {
	return salary;
}

public void setId(int id) {
	this.id = id;
}

  
public void setName(String name) {  
    this.name = name;  
}  
  
@Override
public String toString() {
	return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + "]";
}

public void setSalary(float salary) {
	this.salary = salary;
}  
  
} 