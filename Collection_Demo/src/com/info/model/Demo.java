package com.info.model;

import java.text.NumberFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;


interface map1{
	public void display();
}

abstract class map2 implements map1{
	abstract public void add();
}

class map3 extends map2 implements map1{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}
	
}

public class Demo {
	public static void main(String[] args) {
		
	
		Student s1= new Student("Deevanshu", 101);
		Student s2= new Student("Deevanshu", 101);
		
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode());

		NumberFormat num= NumberFormat.getNumberInstance();
		NumberFormat num2= NumberFormat.getNumberInstance();
		
		System.out.println(num==num2);
		System.out.println(num.equals(num2));
		System.out.println(num.hashCode()==num2.hashCode());
/*	HashMap<Student, Integer> hashmap = new HashMap<Student, Integer>();

	hashmap.put(new Student("Deevanshu",101), 101);
	hashmap.put(new Student("Kunal",102), 102);
	System.out.println(hashmap);*/
	

	
		Entry<Integer,Integer> enty;
	}

}
