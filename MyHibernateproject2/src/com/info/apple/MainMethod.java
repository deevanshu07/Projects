package com.info.apple;

class A extends Object {
	A() {
		System.out.println("Super class constructor");
	}

	void disp() {
		System.out.println("DISP METHOD");
	}
}

class B extends A {
	B() {
		System.out.println("Sub class constructor called");
	}

}

class C extends B {
	C() {
		System.out.println("Class C constructor called");
	}

}



abstract class inter{
	static int i=10;
	static void dsip(){
		
	}
	
}
class AA extends inter {

	int i = 20;

	
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("DEEE");
	}

}

public class MainMethod {
	public static void main(String[] args) {

	}

}
