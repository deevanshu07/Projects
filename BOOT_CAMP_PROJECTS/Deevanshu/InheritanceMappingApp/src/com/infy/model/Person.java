package com.infy.model;

public class Person {
	private int id;
	private String name;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Person(String name) {
		super();
		this.name = name;
	}

}