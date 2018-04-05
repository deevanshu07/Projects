package com.info.model;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

	public List<User> getAllUsers(){ 
		List<User> userList=new ArrayList<User>(); 
	     userList.add(new User(1, "Deevanshu", "SE"));
	     userList.add(new User(2, "Kunal", "SE"));
	     userList.add(new User(3, "Aakash", "SE"));
	     System.out.println("Users addition"); 
	     return userList; 
	}
	
}
