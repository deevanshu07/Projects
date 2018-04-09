package com.infy.model;

import java.util.List;


public class Course {
	int id;
	String name;
	int  fee;
	List<String> topics;
	
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
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public List<String> getTopics() {
		return topics;
	}
	public void setTopics(List<String> topics) {
		this.topics = topics;
	}
	public Course(String name, int fee, List<String> topics) {
		super();
		this.name = name;
		this.fee = fee;
		this.topics = topics;
	}
	

}
