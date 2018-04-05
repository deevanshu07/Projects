package com.info.apple;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class MyClass {

	public static void main(String[] args) {
		Hashtable hashTable = new Hashtable();
		HashMap<Integer,String> hashMap= new HashMap<Integer,String>();
		hashMap.put(1, "ABC");
		hashMap.put(2, "ABCD");
		hashMap.put(3, "ABCDE");
		Set hashset=hashMap.entrySet();
		for (Map.Entry<Integer,String> object : hashMap.entrySet()) {
			System.out.println(object);
			
			
		}
		
		hashTable.put(1, "Deevanshu");
		hashTable.put(2, "nshu");
		hashTable.put(3, "Du");
		hashTable.put(4, "Dshu");
		String str;
		Enumeration enu= hashTable.keys();
		enu= hashTable.elements();
		
		
	}
}
