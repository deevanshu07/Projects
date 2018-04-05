package com.info.model;

public class Setter_Inject {
	private int id;
	private String name;
	private String city;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

	void display(){
		System.out.println("Id is="+id);
		System.out.println("Name is="+name);
		System.out.println("City is="+city);
	}
}
