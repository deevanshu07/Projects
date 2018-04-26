package com.soft.model;

public class Customer 
{

	private long number;
	private int duration;
	
	public long getNumber() 
	{
		return number;
	}
	public void setNumber(long number) 
	{
		this.number = number;
	}
	public int getDuration() 
	{
		return duration;
	}
	public void setDuration(int duration) 
	{
		this.duration = duration;
	}
	
	public Customer(long number, int duration) 
	{
		super();
		this.number = number;
		this.duration = duration;
	}
	

}
