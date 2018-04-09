package com.infy.model;



public class Batch {
	public String getBmode() {
		return bmode;
	}
	public void setBmode(String bmode) {
		this.bmode = bmode;
	}
	int id;
	String slot;
	String bmode;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	
	
	public Batch() {
		// TODO Auto-generated constructor stub
	}
	public Batch(String slot, String bmode) {
		super();
		this.slot = slot;
		this.bmode = bmode;
	
	}
	
}
