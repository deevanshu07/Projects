import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ByteReader {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		ByteArrayOutputStream bite= new ByteArrayOutputStream();
		String str="Byte Array Output Stream";
		byte value[]=str.getBytes();
		
		for(int i=0;i<value.length;i++)
		{
			bite.write(value[i]);
			bite.writeTo(new FileOutputStream("file3.txt"));
			System.out.println(bite.toString());
		}
		

	}

}
