package com.infogain.model;

public class Student extends Person {

	private String course;

	private double fee;

	

	public Student(String name,String course, double fee) {
		super(name);
		
		this.course = course;
		this.fee = fee;
	}

	public String getCourse() {
		return course;
	}

	public double getFee() {
		return fee;
	}
	public void setCourse(String course) {
		this.course = course;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
}
