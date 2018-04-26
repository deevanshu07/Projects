import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class CharDemo
{

	
	public static void main(String[] args) throws IOException 
	{
	FileOutputStream out= new FileOutputStream("characterReader.txt");
	
	String str="This is Character Array Writer Demo";
	
	 byte array[]=str.getBytes();
	 
	 for(int i=0;i<array.length;i++)
	 {
		 out.write(array[i]);
	 }

	 out.flush();
	 out.close();
	}

}
