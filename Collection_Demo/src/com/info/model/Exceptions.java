package com.info.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Address1 implements Serializable {
	private static final long serialVersionUID = 1L;
	private String streetName;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((streetName == null) ? 0 : streetName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address1 other = (Address1) obj;
		if (streetName == null) {
			if (other.streetName != null)
				return false;
		} else if (!streetName.equals(other.streetName))
			return false;
		return true;
	}

	public Address1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address1(String streetName) {
		super();
		this.streetName = streetName;
	}

	private void readObject(ObjectInputStream aInputStream)
			throws ClassNotFoundException, IOException {
		aInputStream.defaultReadObject();
	}

	private void writeObject(ObjectOutputStream aOutputStream)
			throws IOException {
		aOutputStream.defaultWriteObject();
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	@Override
	public String toString() {
		return "Address1 [streetName=" + streetName + "]";
	}

}

public class Exceptions {
	transient static int i = 10;

	public static boolean equals() {
		System.out.println("Deevanshu");
		return true;

	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {

		/*
		 * FileWriter fw= new FileWriter("file.txt"); String
		 * str[]={"Deevanshu Mahajan", "CSE", "Infogain India"}; for (int i = 0;
		 * i < str.length; i++) { fw.write(str[i]+"\n"); } fw.write(i);
		 * System.out.println("Success"); fw.close();
		 * 
		 * FileReader file = new FileReader("file.txt"); int i;
		 * while((i=file.read())!=-1){ System.out.print((char)i); }
		 */

		Address1 address;
		FileInputStream fin = new FileInputStream("Address.txt");
		ObjectInputStream ois = new ObjectInputStream(fin);
		address = (Address1) ois.readObject();
		ois.close();

	}

}
