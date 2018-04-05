package com.info.model;

public class A {

	private static final A obj = new A();

	private A() {
	}

	public static A getA() {
		System.out.println("Factory Method");
		return obj;
	}
	
	public void msg(){
		System.out.println("Hello User");
	}
}
