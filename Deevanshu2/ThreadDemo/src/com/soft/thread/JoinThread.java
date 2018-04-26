package com.soft.thread;


class NewThread implements Runnable
{
	String name;
	Thread t;
	
	public NewThread(String threadname)
	{
		name=threadname;
		t=new Thread(this,name);
		System.out.println("New Thread "+t);
		t.start();
	}
	@Override
	public void run() 
	{
		try
		{
		for(int i=2;i>0;i--)
		{
			System.out.println("Index of Thread is "+ i);
			Thread.sleep(1000);
		}
		}
		catch(Exception e)
		{
			  System.out.println(name + " interrupted.");
	    }
	    System.out.println(name + " exiting.");
	}
		
		
	}

public class JoinThread {

	public static void main(String[] args) 
	{

		 NewThread ob1 = new NewThread("One");
		  NewThread ob2 = new NewThread("Two");
		  System.out.println("Thread one is Alive or not"+ob1.t.isAlive());
		  System.out.println("Thread second is Alive or not"+ob2.t.isAlive());
		  
		  System.out.println("Wait for Threds To finish");
	  try 
	  {
			ob1.t.join();
			ob2.t.join();
		} 
	  catch (InterruptedException e) 
	  {
			
			e.printStackTrace();
		}
	  System.out.println("Thread one is Alive or not"+ob1.t.isAlive());
	  System.out.println("Thread second is Alive or not"+ob2.t.isAlive());
	}

}
