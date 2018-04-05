package com.info.factoryBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadDemo {
	public static void main(String[] args) {
		String str = null;
		List<User> strList= new ArrayList<User>();
		strList.add(new User("Deevanshu", 23));
		strList.add(new User("Mahajan", 19));
		strList.add(new User("XYZ", 21));
		System.out.println(strList);
		Collections.sort(strList);
		System.out.println(strList);
	}
}
