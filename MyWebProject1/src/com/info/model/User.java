package com.info.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String profession;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String profession) {
		
		this.id = id;
		this.name = name;
		this.profession = profession;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getProfession() {
		return profession;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public void setProfession(String profession) {
		this.profession = profession;
	}

	
}