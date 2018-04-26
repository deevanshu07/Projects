package com.soft.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInput 
{
	public static void main(String[] args) throws IOException 
	{
		FileInputStream file= new FileInputStream("newFile.txt");
		FileOutputStream file1= new FileOutputStream("newFile2.txt");
		
		int data=0;
		while((data=file.read())!=-1)
		{
			file1.write(data);
		}
		file.close();
		System.out.println("Data Read Successfully");
		
		

	}

}
