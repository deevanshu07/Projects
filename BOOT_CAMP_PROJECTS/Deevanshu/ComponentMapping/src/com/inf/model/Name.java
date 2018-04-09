package com.inf.model;

public class Name
{

	
	private String initial;
	private String first;
	private String last;
	
	public Name()
	{
		
	}
	
	public Name(String initial, String first, String last) {
		super();
		this.initial = initial;
		this.first = first;
		this.last = last;
	}
	
	public String getInitial() {
		return initial;
	}
	public void setInitial(String initial) {
		this.initial = initial;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}

}
