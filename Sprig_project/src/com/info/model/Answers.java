package com.info.model;

public class Answers {
	private int id;
	private String name;

	public Answers() {
	}

	public Answers(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Questions [id=" + id + ", name=" + name + "]";
	}

}
