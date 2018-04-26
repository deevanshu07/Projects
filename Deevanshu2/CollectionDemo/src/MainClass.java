import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class MainClass {

	
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		BufferedReader buffer;
		try 
		{
			buffer= new BufferedReader(new FileReader("collection.txt"));
			String str;
			String str1[];
			
			while(buffer!=null)
			{
				str=buffer.readLine();
				if(str!=null)
				{
				str1=str.split(",");
				for(int i=0;i<str1.length;i++)
				{
					System.out.print(str1[i]);
				}
				System.out.println();
				}
				else break;
			}	
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
