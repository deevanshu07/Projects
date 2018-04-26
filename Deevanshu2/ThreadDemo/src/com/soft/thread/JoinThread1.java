package com.soft.thread;


class Newthread1 implements Runnable
{
	Thread t1;
	String name;
	
	Newthread1(String name)
	{
		t1= new Thread(name);
		System.out.println(t1.getName());
		t1.start();
	}

	@Override
	public void run() 
	{
		for(int i=5;i>0;i--)
		{
			System.out.println("thread "+name+"is Running");
		}
		
	}
	
}

public class JoinThread1 
{

	public static void main(String[] args) 
	{
		Newthread1 thread1= new Newthread1("Deevanshu Thread");
		Newthread1 thread2=new Newthread1("Prince Thread");
		System.out.println("Ist"+thread1.t1.isAlive()+"\t"+thread1.t1.getName());
		System.out.println("Second"+thread2.t1.isAlive()+"\t"+thread2.t1.getName());

	}

}
