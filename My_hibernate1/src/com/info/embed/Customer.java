package com.info.embed;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue
	int customerId;
	Name name;
	String location;
	int contact;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Customer(Name name, String location, int contact) {
		super();
		this.name = name;
		this.location = location;
		this.contact = contact;
	}
	public int getContact() {
		return contact;
	}
	public int getCustomerId() {
		return customerId;
	}
	
	public String getLocation() {
		return location;
	}
	@Embedded
	public Name getName() {
		return name;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setName(Name name) {
		this.name = name;
	}

	
}
