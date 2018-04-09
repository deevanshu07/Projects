
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DemoMap 
{
	public static void main(String args[]) throws IOException
	{
	/*FileInputStream file = new FileInputStream("C:/Users/DEEVANSHU.MAHAJAN/Desktop/dee1.txt");
	FileOutputStream file2 = new FileOutputStream("C:/Users/DEEVANSHU.MAHAJAN/Desktop/dee.txt");*/
	BufferedReader buffer = new BufferedReader(new FileReader("C:/Users/DEEVANSHU.MAHAJAN/Desktop/dee1.txt"));
		 
   
	String v=buffer.readLine();
	String m=buffer.readLine()+1;
	
    String[] t=v.split(" ,");
    
   
    for(int i=0;i<t.length;i++)
    {
    	 
    	System.out.print(t[i]);
    		
		}

	
	}
	
}
	