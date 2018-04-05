package com.info.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

interface myInterface {
	void method1();

	void method2();
}

abstract class Parent implements myInterface {
	public abstract void method1();
}

abstract class Child extends Parent implements myInterface {
	public void method1() {

	}

	public abstract void method2();
}

/*
 * class Parent { protected static int count = 0;
 * 
 * public Parent() { count++; }
 * 
 * static int getCount() { return count; } }
 */

class SuperMultiplier {
	public int multiplyExtra(int a, int b) {
		return this.multilyNumber(a, b);
	}

	protected int multilyNumber(int a, int b) {
		return a * b * 3;
	}
}

class SubMultiplier extends SuperMultiplier {
	public int multiplyExtra(int a, int b) {
		System.out.println("NU");
		return super.multilyNumber(a * 5, b);
	}
}

class Base {
	int num = 10;

	Base() {

		num = 20;
	}
}

final class A {
	String name;
	int id;

	public A() {
		System.out.println("Constructor initialized");
	}

	public A(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "A [name=" + name + ", id=" + id + "]";
	}
}

class Singleton {
	private static Singleton single;

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (single == null)
			single = new Singleton();
		return single;
	}

}



public class Main extends Base {
	/*
	 * public Main() { count++; }
	 */
	/*
	 * static int total=10; public void calc(){ int total=3;
	 * System.out.println(this.total); }
	 */
	public static void main(String[] args) throws Exception {


		/*
		 * Base b = new Base(); System.out.println(b.num); b.num=40;
		 * System.out.println(b.num);
		 * 
		 * Main main= new Main(); main.calc();
		 * 
		 * System.out.println(getCount()); Main main= new Main();
		 * System.out.println(getCount());
		 * 
		 * 
		 * 
		 * System.out.println(Math.round(123456789123456789.12f));
		 * 
		 * 
		 * 
		 * SuperMultiplier sup= new SubMultiplier();
		 * System.out.println(sup.multiplyExtra(1, 2));
		 * 
		 * 
		 * Random r = new Random(); int result = r.nextInt(7);
		 * System.out.println(result);
		 * 
		 * 
		 * Innvoice sales= new Innvoice();
		 * System.out.println(sales.formatId("1234"));
		 * System.out.println(Innvoice.formatId("1234"));
		 * 
		 * 
		 * double d= -27.2345; System.out.println( Math.ceil(d));
		 * System.out.println(Math.round(d)); System.out.println(Math.abs(d));
		 * System.out.println(Math.floor(d));
		 * 
		 * 
		 * Innvoice inn= new Innvoice();
		 * System.out.println(inn.formatId("Parent"));
		 * 
		 * 
		 * String str = "{{[]}}"; Stack<String> stack = new Stack<String>(); for
		 * (int i = 0; i < str.length(); i++) { char c = str.charAt(i); if (c ==
		 * '(' || c == '{' || c == '[') { stack.push("" + c); } if (c == ')' ||
		 * c == '}' || c == ']') { if (stack.isEmpty()){
		 * System.out.println("Parenthesis are not matched"); System.exit(0); }
		 * char poppedElement = stack.pop().charAt(0); if ((poppedElement == '('
		 * && c == ')') || (poppedElement == '{' && c == '}') || (poppedElement
		 * == '[' && c == ']')) { continue; } else {
		 * System.out.println("Parenthesis are not matched"); System.exit(0); }
		 * } } System.out.println("Parenthesis are matched");
		 * 
		 * 
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("Spring-Module.xml"); Car
		 * c=(Car)context.getBean("c"); System.out.println(c);
		 */

		//ApplicationContext context= new ClassPathXmlApplicationContext("Spring-Module.xml");
		//ApplicationContext context = new ClassPathXmlApplicationContext(
				//"Spring-Module.xml");
		/*Car c1= context.getBean(Car.class);		
		System.out.println(c1);*/
		
		//DependencyB obj=context.getBean(DependencyB.class);
		//System.out.println(obj);
		
		
		
		HashMap<String, Integer> hashMap= new HashMap<String, Integer>();
		HashMap<StringBuffer, Integer> hashMap1= new HashMap<StringBuffer, Integer>();
		
		String str="abc";
		hashMap.put(str, 1);
		hashMap.put("DEF", 2);
		str=str.toUpperCase();
		System.out.println(str);
		System.out.println(hashMap);

		StringBuffer buff= new StringBuffer("ABC");
		StringBuffer buff1= new StringBuffer("DEF");
		hashMap1.put(buff, 1);
		hashMap1.put(buff1, 2);
		buff.append("CCCC");
		buff1.append("VVV");
		
		System.out.println(buff);
		System.out.println(buff1);
		System.out.println(hashMap1);

		

	}
}

class Emp implements Comparable<Emp>{
	int id;
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}
	String name;
	Emp(int id, String name){
		this.id=id;
		this.name=name;
	}
	@Override
	public int compareTo(Emp arg0) {
		// TODO Auto-generated method stub
		return this.id-id;
	}
}
class Innvoice {
	public static String formatId(String oldId) {
		return oldId + "_Invoice";
	}
}

class SalesInnvoice extends Innvoice {
	public static String formatId(String oldId) {
		return oldId + "_Sales_Innvoice";
	}
}
