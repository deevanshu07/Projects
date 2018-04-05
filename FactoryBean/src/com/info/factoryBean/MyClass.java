package com.info.factoryBean;

class Car1 {
	private int a = 5;
	 public void a(Car1 c) {
		System.out.println("5");
	}
}

class Vehicle extends Car1 {
	int a = 10;
	public void a(Vehicle v) {
		System.out.println("10");
	}
}

class MyClass {
	public static void main(String[] args) {

		/*Car1 v = new Vehicle();
		v.a(new Car1());
		v.a(new Vehicle());*/
		
		String str=null;
		if(str.equals(" "))
		{
			System.out.println("Deevanshu");
		}
		else
		{
			System.out.println("Mahajan");
		}
	}

}
