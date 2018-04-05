package com.info.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comaprables {
	public enum Season {
		WINTER, SUMMER, SPRING, FALL
	}

	public static void main(String[] args) {

		List<Stud> arrayList1 = new ArrayList<Stud>();
		arrayList1.add(new Stud(101, "Deevanshu"));
		arrayList1.add(new Stud(90, "Atul"));
		arrayList1.add(new Stud(100, "Vinay"));
		Collections.sort(arrayList1);
		System.out.println(arrayList1);

		for (Season stud : Season.values()) {
				System.out.println(stud);
		}

	}
}

class Stud implements Comparable<Stud> {

	private String name;
	private int rollNumber;

	public Stud() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stud(int rollNumber, String name) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
	}

	@Override
	public int compareTo(Stud o) {
		return this.getName().compareTo(o.getName());
	}

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
		return "Stud [rollNumber=" + rollNumber + ", name=" + name + "]";
	}

}
