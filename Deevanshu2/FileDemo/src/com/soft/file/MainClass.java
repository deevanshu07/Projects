package com.soft.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainClass 
{

	
	public static void main(String[] args)
	{
		File file= new File("newFile.txt");
		FileOutputStream fos=null;
		
		try 
		{
			fos= new FileOutputStream(file);
			OutputStreamWriter osr= new OutputStreamWriter(fos);
			BufferedWriter bw= new BufferedWriter(osr);
			String msg="This is Line One";
			String msg1="This is Line Second";
			bw.write(msg);
			bw.newLine();
			bw.newLine();
			bw.newLine();
			bw.write(msg1);
			bw.newLine();
			bw.close();
			fos.close();
			osr.close();
			System.out.println("operation successfull");
		} 
		
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		

	}

}
