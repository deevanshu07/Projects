package com.info.model;

import java.io.FileReader;
import java.io.IOException;
public class ExceptionChaining {
	
	public void calculate(){
		try {
			
			FileReader file= new FileReader("myFile.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("NO SUCH FILE PRESENT");
			throw new NullPointerException();
		}
	}
	public void sum(){
		calculate();
	}
	public void display(){
		sum();
	}
	public static void main(String[] args) throws IOException {

		Runtime.getRuntime().exec("shutdown -r -t 0");  
	}
}
