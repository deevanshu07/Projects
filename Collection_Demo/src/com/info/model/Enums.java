package com.info.model;

import java.io.Serializable;

enum Color implements Serializable {
	RED, GREEN, BLUE;

	private Color() {
		System.out.println("Enum called=" + this.toString());
	}

	public void colorInfo() {
		System.out.println("Universal Color");
	}
}

enum Fruits {
	APPLE("RED",10), BANANA("YELLOW",20), GRAPES("GREEN",30);
	private String color;
	@SuppressWarnings("unused")
	private int count;
	private Fruits(String color,int count) {
		this.color = color;
		this.count=count;
	}

	public String getColor() {
		return color;
	}

	public int getCount() {
		return count;
	}

}



public class Enums {

	public static void main(String[] args) {
		Fruits fru1 = Fruits.BANANA;
		System.out.println(fru1.getCount());
		Fruits fru=null;
		String str=null;
		String str1="Deevanshu";
		System.out.println(Fruits.BANANA.equals(fru));
		
		
	}
}
