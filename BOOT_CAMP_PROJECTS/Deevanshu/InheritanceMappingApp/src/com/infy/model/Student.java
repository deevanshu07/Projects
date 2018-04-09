package com.infy.model;

public class Student extends Person {
	private String course;
	private double fee;
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name,String course, double fee) {
		super(name);
		this.course = course;
		this.fee = fee;
	}
	
	
	

}
