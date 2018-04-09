import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Date;


public class java {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		Date order = new Date();
		System.out.println(order.toString().substring(0,3));
		
		byte b;
		FileInputStream file = new FileInputStream("C:/Users/DEEVANSHU.MAHAJAN/Desktop/dee.txt");
		
		
		
		
		
		while((b=(byte)(file.read()))!=-1)
		{
			System.out.println((char)(b));
		}
		
		
		file.close();

	}

}
