package com.infy.model;

public class Country {
	int id;
	String name;
	
	HeadOfState hos;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HeadOfState getHos() {
		return hos;
	}
	public void setHos(HeadOfState hos) {
		this.hos = hos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
