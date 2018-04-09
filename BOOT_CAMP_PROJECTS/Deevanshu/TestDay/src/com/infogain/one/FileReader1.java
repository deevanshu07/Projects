package com.infogain.one;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


class FileReader1
{
	public static void main(String[] args) 
	{
		int array[] = new int[8];
		
		try { 
			BufferedReader bufferreader = new BufferedReader(new FileReader("C:/Users/DEEVANSHU.MAHAJAN/Desktop/dee1.txt"));
	
				String splitFile=" ";
				int length=0;
				String length1;
				String[] splitValue= new String[3];
				
				
				while(bufferreader!=null)
				{
					length1=bufferreader.readLine();
					length++;
					
				}
				for(int j=0;j<3;j++)
				{
					
					
					
					
					
					splitFile=bufferreader.readLine();
					splitValue= splitFile.split(",");
					
					/*splitValue= splitFile.split(",");*/
					for(int i=0;i<length;i++)
					{
						System.out.print(splitValue[i]+" ");
						
					}
					
					System.out.println();	
				}
				
				bufferreader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Updating the File");
		try 
		{
			BufferedWriter bufferWriter = new BufferedWriter(new FileWriter("C:/Users/DEEVANSHU.MAHAJAN/Desktop/dee1.txt"));
			
			
			
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}