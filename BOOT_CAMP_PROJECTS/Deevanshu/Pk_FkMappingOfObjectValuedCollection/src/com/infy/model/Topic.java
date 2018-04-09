package com.infy.model;

public class Topic {
	int id;
	String name;
	int weightage;
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
	public int getWeightage() {
		return weightage;
	}
	public void setWeightage(int weightage) {
		this.weightage = weightage;
	}
	public Topic(String name, int weightage) {
		super();
		this.name = name;
		this.weightage = weightage;
	}

}
