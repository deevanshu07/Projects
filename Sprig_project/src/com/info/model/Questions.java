package com.info.model;

public class Questions {
	private int id;
	private String name;

	public Questions() {
	}

	public Questions(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Questions [id=" + id + ", name=" + name + "]";
	}

}
