package com.info.model;


class Customer {
	int amount = 100;

	synchronized void deposit(int amount) {
		System.out.println("Depositing amount");
		this.amount+=amount;
		System.out.println("Deposit Completed");
		notify();

	}

	synchronized void withdraw(int amount) {
		System.out.println("Withdrawing amount");
		if (this.amount < amount) {
			System.out.println("Less amount: wait for deposit");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		this.amount-=amount;
		System.out.println("Withdraw completed");
		
	}
}

class Test<T extends Number & Runnable>{
	void display(){
		
	}
}

public class ThreadCommunication {
	public static void main(String[] args) {

		final Customer c= new Customer();
		new Thread(){
			public void run(){
				c.withdraw(150);
			}
		}.start();
		
		new Thread(){
			public void run(){
				c.deposit(200);
			}
		}.start();
	}

}
