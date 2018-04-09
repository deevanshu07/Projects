import java.io.*;
public class Question_1 {

	public static void main(String[] args) 
	{
	
		FileReader fr;
		try
		{
		fr= new FileReader("C:/Users/DEEVANSHU.MAHAJAN/Desktop/local.txt");
		int data=0;
		while ((data=fr.read())!=-1) 
		{
			char charData =(char) data;
			System.out.print(charData);
			
		}
		fr.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		
		finally
		{
			System.out.println("\n");
			System.out.println("Finally would execute");
		}
		
		System.out.println("Hello");
		
	}

}
