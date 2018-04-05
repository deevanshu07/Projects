package com.info.apple;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "info_student")
public class Student1 extends Person {

	String course;
	int fee;

	public Student1(String name, String course, int fee) {
		super(name);
		this.course = course;
		this.fee = fee;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public Student1() {
		// TODO Auto-generated constructor stub
	}

}
