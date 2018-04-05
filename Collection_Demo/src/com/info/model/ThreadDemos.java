package com.info.model;

class MyThread extends Thread {
	synchronized public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(500);
				System.out.println(i + "NAME="
						+ Thread.currentThread().getName());

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("Thread Running");
	}
}

class MyThread1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {

				Thread.sleep(500);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i + "NAME=" + Thread.currentThread().getName());

		}
		System.out.println("Thread Running");

	}

}

class ABC{
	public ABC(){
		System.out.println("Super called");
	}
	public ABC(String name){
		System.out.println("Super named constructor called");
	}
	public void display(){
		System.out.println("Displaying");
	}
}

class DEF extends ABC{
	public DEF(){
		super();
	System.out.println("DISPLAING");
	}
	public DEF(String name){
		this();
		System.out.println("DDD");
	}
	
	public DEF(String name, String id){
		this("Deevanshu");
	}
	public void display(){
		
		System.out.println("CHILD DISPLAY");
	}
}
public class ThreadDemos {
	public static void main(String[] args) {

		/*
		 * MyThread1 threadObject= new MyThread1(); Thread t1=new
		 * Thread(threadObject); Thread t2=new Thread(threadObject); t1.start();
		 * t2.start();
		 */
/*
		MyThread t3 = new MyThread();
		MyThread t4 = new MyThread();
		t3.start();
		t4.start();*/
		DEF d= new DEF("","");
		System.out.println(d);
		
		

	}
}
