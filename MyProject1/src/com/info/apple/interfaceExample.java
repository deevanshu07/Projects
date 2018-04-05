package com.info.apple;
interface a {
	int x = 10;
	void show();
}

interface b {
	int x = 20;
	void show();
}

class superClass {
	public int calaulate() {
		return 5;
	}

}

class subClass extends superClass {
	public int calculate() {
		return 10;
	}
}

abstract class ab implements a{
	abstract void add() throws Exception;
}


abstract class abc extends ab{
	
}

class Sample extends abc{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void add() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}

public class interfaceExample implements a, b {
	public static void main(String[] args) {
		System.out.println(b.x);
		superClass sup = new subClass();
		System.out.println("Result=" + sup.calaulate());
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}
}
