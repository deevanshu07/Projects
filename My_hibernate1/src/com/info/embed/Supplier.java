package com.info.embed;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supplier")
public class Supplier {

	Name name;
	private String officeAddress;
	@Id
	@GeneratedValue
	private int supplierId;
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Supplier(Name name, String officeAddress) {
		super();
		this.name = name;
		this.officeAddress = officeAddress;
	}
	public Name getName() {
		return name;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", name=" + name
				+ ", officeAddress=" + officeAddress + "]";
	} 
}
