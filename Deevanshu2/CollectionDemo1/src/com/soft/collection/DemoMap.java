package com.soft.collection;
import java.util.HashMap;
import java.util.Map;

public class DemoMap {
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		Map<Integer,String> map=new HashMap<Integer, String>();
		 map.put(100,"Deevanshu");
		 map.put(101,"Jack");
		 map.put(102,"Dhan");
		 System.out.println(map);
		 map.put(null,null); 
		 System.out.println(map);
		 map.put(null,"123");
		 System.out.println(map);
	}

}
