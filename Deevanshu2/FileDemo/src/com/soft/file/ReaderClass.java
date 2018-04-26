package com.soft.file;
import java.io.*;
public class ReaderClass {

	public static void main(String[] args) throws IOException 
	{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str;
		System.out.println("Enter Any String ");
		do
		{
			str=br.readLine();
			System.out.println(str);
			
		}while(!str.equalsIgnoreCase("stop"));

		//bw.close();
		
	}

}
