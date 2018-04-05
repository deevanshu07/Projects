package com.info.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
@NamedQueries({
	@NamedQuery( name="GET_ALL_USERS",
				 query="from User")
})
public class User {
	@Id
	private int id;
	private String name;
	private int age;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}


	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
