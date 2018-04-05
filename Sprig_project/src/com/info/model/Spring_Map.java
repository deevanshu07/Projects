package com.info.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Spring_Map {

	private int id;
	private String name;
	private Map<Questions,Answers> answers=new HashMap<Questions, Answers>();  

	public Spring_Map() {
	}

	public Spring_Map(int id, String name, Map<Questions, Answers> answers) {
		super();
		this.id = id;
		this.name = name;
		this.answers = answers;
	}

	public void displayInfo() {
		System.out.println("question id:"+id);  
	    System.out.println("question name:"+name);  
	    System.out.println("Answers....");  
	    Set<Entry<Questions, Answers>> set=answers.entrySet();  
	    Iterator<Entry<Questions, Answers>> itr=set.iterator();  
	    while(itr.hasNext()){  
	        Entry<Questions, Answers> entry=itr.next();  
	        Questions ans=entry.getKey();  
	        Answers user=entry.getValue();  
	        System.out.println("Answer Information:");  
	        System.out.println(ans);  
	        System.out.println("Posted By:");  
	        System.out.println(user);  
	    }  

	}
}
