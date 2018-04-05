package com.info.model;

class A{
	 void disp(){
		
	}
}
class B extends A{
	protected void disp(){
		System.out.println("CALLING");
	}
}

public class Inheritance {
	public static void main(String[] args) {
		A a= new B();
		a.disp();
	}

}
