package com.soft.thread;

public class DaemonThread extends Thread
{

	public DaemonThread()
	{
		
	}
	
	public void run()
	{
		System.out.println("Inside Daemon Thread");
		System.out.println("Name of thread is "+isDaemon()+" "+isAlive());
	}
	public static void main(String[] args) 
	{
		DaemonThread dt=new DaemonThread();
		dt.start();

	}

}
