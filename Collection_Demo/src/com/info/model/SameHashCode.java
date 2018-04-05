package com.info.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

class Key {
	String key;

	Key(String key) {
		this.key = key;
	}

	public int hashCode() {
		int hash = (int) key.charAt(0);
		System.out.println("hashCode for key: " + key + " = " + hash);
		return hash;
	}

	public boolean equals(Object obj) {
		return key.equals(((Key) obj).key);
	}
}

public class SameHashCode {
	public static void main(String[] args) {

		HashMap map = new HashMap();
		ConcurrentHashMap<Integer, Integer> con = new ConcurrentHashMap<Integer, Integer>();
		Set<Integer> hashSet = new HashSet<Integer>();
		Vector<Integer> vector = new Vector<Integer>();
		List<Integer> list = new ArrayList<Integer>();

		Collections.sort(vector);
		Collections.sort(list);
		con.put(1, 1);
		map.putAll(con);

		/*
		 * map.put(new Key("vishal"), 20); map.put(new Key("sachin"), 30);
		 * map.put(new Key("vaibhav"), 40); map.put(new Key("vaibhav"), 40);
		 */

		// System.out.println(map);
		// System.out.println(map.get(new Key("vishal") ).equals(map.get(new
		// Key("vaibhav"))));

		Map<Integer, String> map1 = new HashMap<Integer, String>();
		Map<Integer, String> map2 = new HashMap<Integer, String>();

		map1.put(1, "Deevanshu");
		map1.put(2, "Vinay");
		map1.put(3, "Ashu");

		map2.put(1, "Deevanshu");
		map2.put(2, "Vinay1");
		map2.put(3, "Ashu1");

		System.out.println(map1.get(1).hashCode());
		System.out.println(map2.get(1).hashCode());
		
	}

}
