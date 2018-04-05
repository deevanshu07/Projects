package com.info.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



class Address implements Serializable{
	private String area;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String area) {
		super();
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Address [area=" + area + "]";
	}
}


class Person implements Serializable{
	private String name;
	Address add;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, Address add) {
		super();
		this.name = name;
		this.add = add;
	}
	public Address getAdd() {
		return add;
	}
	public String getName() {
		return name;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", add=" + add + "]";
	}
}


public class SerializableExample {
	public static void main(String[] args) throws Exception{
		
		Person p= new Person("Deevanshu", new Address("Noida"));
		FileOutputStream fout=new FileOutputStream("f.txt");  
		  ObjectOutputStream out=new ObjectOutputStream(fout);  
		  
		  out.writeObject(p);  
		  out.flush();  
		  System.out.println("success");  
		  
		  ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));  
		  Person p1= (Person) in.readObject();
		  System.out.println(p1.getAdd().getArea());  
		  
		  in.close();  
		  
		  
	}

}
