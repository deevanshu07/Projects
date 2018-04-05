package com.info.model;



final class MyClass {
	private final String name;
	private final String age;

	public static MyClass getMyClass(String name, String age) {
		return new MyClass(name, age);
	}

	public MyClass(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "MyClass [name=" + name + ", age=" + age + "]";
	}

}

public class ImmutableClass {
	public static void main(String[] args) {
	}
	

}
