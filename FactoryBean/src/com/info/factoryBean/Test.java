package com.info.factoryBean;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Vehile {
	int a = 5;

	public void a() {
		System.out.println("5");
	}
}

class Car extends Vehile {
	int a = 10;

	public void a() {
		System.out.println("10");
	}
}

public class Test {
	public enum Season { WINTER, SPRING, SUMMER }  
	public static void main(String[] args) {
		
		
		for (Season s : Season.values()) {
			System.out.println("Value of s="+s);
		}
		
		/*
		 * Vehile v = new Car(); System.out.println(v.a); v.a();
		 */

/*		User user = new User();
		User user1 = new User();

		System.out.println(user.equals(user1));

		HashMap<Integer, String> userMap = new HashMap<Integer, String>();
		userMap.put(101, "Deevanshu");
		userMap.put(102, "Deevanshu");
		userMap.put(103, "Deevanshu");
		userMap.put(104, "Deevanshu");
		for (Map.Entry<Integer, String> entry : userMap.entrySet()) {
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "\n" + value);*/
			
			/*HashMap<User, String> hashMap= new HashMap<User, String>();
			hashMap.put(new User("Deevanshu", 23), "101");
			hashMap.put(new User("Deevanshu",23), "102");
			
			
			for(Map.Entry<User, String> entry: hashMap.entrySet())
			{
				User u=entry.getKey();
				String value=entry.getValue();
				System.out.println("Key="+u+"\n");
				System.out.println("Value="+value);
			}*/
		
		User u= new User("Deevanshu", 23);
		User u1= new User("Deevanshu", 23);
		
		System.out.println(u.equals(u1));
		
		String str="Hello";
		System.out.println(str);
		
		String s1="Deevanshu";
		String s2="Deevanshu";
		String s3="Deevanshu".intern();
		
		if(s1==s2)
		{
			System.out.println("YESSS");
		}
		if(s1==s3)
		{
			System.out.println("NOOOOO");
		}
		
		HashMap<String, String> userMap1 = new HashMap<String, String>();
		userMap1.put("DEE", "Deevanshu");
		userMap1.put("AAAAAA", "Mahajan");
		
		System.out.println(userMap1);
		
		TreeMap<String, String> userMap = new TreeMap<String, String>();
		userMap.put("DEE", "Deevanshu");
		userMap.put("AAAAAA", "Mahajan");
		
		System.out.println(userMap);
		
		Set<String> integerSet= new HashSet<String>();
		integerSet.add("Deevanshu");
		integerSet.add("Akash");
		integerSet.add("AAAAAAAAa");
		System.out.println(integerSet);
		
		TreeSet<String> treeSet= new TreeSet<String>();
		treeSet.add("Deevanshu");
		treeSet.add("Akash");
		treeSet.add("AAAAAAAAa");
		System.out.println(treeSet);
		
		String s="Equal";
		String ss1= "Equal";
		
		System.out.println(s==ss1);
		System.out.println(s.equals(ss1));
		

	}
}

