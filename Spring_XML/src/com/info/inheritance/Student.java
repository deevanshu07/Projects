package com.info.inheritance;

public class Student {

	private String name;
	private int rollNumber;

	public String getName() {
		return name;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNumber=" + rollNumber + "]";
	}
}
