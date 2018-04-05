package com.info.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Dictionary;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

interface Foo{
	int x=10;
	 void display();
	
}


public class LinkedMap {
	
	
	
	public static void main(String[] args) {

		System.out.println();
		String s="abc";
		String s1="abc";
		String s3=s.concat(s1);
		System.out.println(s3);
		System.out.println(Foo.x);
		char c = 65;
		int x=10*20-20;
		System.out.println(x);
		System.out.println("c = "+c);
		
		try{
			throw new IOException();
			
		}
		catch(IOException  e){
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<Integer, String>();
		linkedMap.put(1, "Deevanshu");
		linkedMap.put(123, "ABCD");
		linkedMap.put(34, "XYZ");
		linkedMap.put(78, "QWZ");
		linkedMap.put(4, "Deevanshu");
		linkedMap.put(null, null);
		System.out.println(linkedMap);
		
		HashMap<Integer, String> linkedMap1 = new HashMap<Integer, String>();
		linkedMap1.put(1, "Dee");
		linkedMap1.put(12, "Deev");
		linkedMap1.put(34, "Deeva");
		linkedMap1.put(78, "Deevan");
		linkedMap1.put(4, "Deevans");
		System.out.println(linkedMap1);

		TreeMap<Integer, String> linkedMap2 = new TreeMap<Integer, String>();
		linkedMap2.put(1, "Dee");
		linkedMap2.put(12, "Deev");
		linkedMap2.put(34, "Deeva");
		linkedMap2.put(78, "Deevan");
		linkedMap2.put(4, "Deevans");
		System.out.println(linkedMap2);
				
		List<String> myList = new ArrayList<String>(2);
		myList.add("deevanshu");
		myList.add("Mahajan");
		myList.add("deevanshu");
		myList.add("deevanshu");
		myList.add("deevanshu");
		System.out.println(myList);
	
		ArrayList<Integer> c11= new ArrayList<Integer>();
		c11.add(1);
		c11.add(12);
		c11.add(123);
		ArrayList<Integer> arrayList= new ArrayList<Integer>(c11);
		System.out.println(arrayList);
		int array[]= new int[5];
		System.out.println(array.length);
		array=Arrays.copyOf(array, 10);
		
		System.out.println(array.length);
		
		HashMap<Days, String> enumMap= new HashMap<Days, String>();
		EnumMap<Days, String> enu= new EnumMap<Days, String>(Days.class);
		enu.put(Days.Monday, "1");
		System.out.println(enu);
		enu.put(null, null);
		
		
		
	}
	public enum Days{
		Monday, Tuesday, Wenesday
	};
}
