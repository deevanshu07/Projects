package com.infy.model;

import java.util.Set;

public class Trainer {
	int id;
	String name;
	Set<Batch> batches;
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
	public Set<Batch> getBatches() {
		return batches;
	}
	public void setBatches(Set<Batch> batches) {
		this.batches = batches;
	}
	public Trainer() {
		// TODO Auto-generated constructor stub
	}
	public Trainer(String name, Set<Batch> batches) {
		super();
		this.name = name;
		this.batches = batches;
	}
	public Trainer(String name) {
		super();
		this.name = name;
	}
	


}
