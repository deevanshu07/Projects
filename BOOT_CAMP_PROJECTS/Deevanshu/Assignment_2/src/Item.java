import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;


class Item
{
	
	
	public static void main(String[] args) throws IOException
	{
	FileInputStream file = new FileInputStream("C:/Users/DEEVANSHU.MAHAJAN/Desktop/local.txt");
	BufferedReader br = new BufferedReader(new InputStreamReader(file));
	FileOutputStream file1 = new FileOutputStream("C:/Users/DEEVANSHU.MAHAJAN/Desktop/local1.txt");

	int data=0;
	

	while((file.read())!=-1)
	{
			br.readLine();
		
		System.out.println(br);
	}	
		{
			System.out.println("\n");
			System.out.println("Finally would execute");
		}
		
		System.out.println("Hello");
		
	}

}

