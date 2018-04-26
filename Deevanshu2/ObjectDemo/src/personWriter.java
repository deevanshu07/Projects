import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class personWriter {

	
	
	public static void main(String[] args) 
	{
		ObjectOutputStream dout= null;
		try
		{
		DataInputStream din;
		dout=new ObjectOutputStream(new FileOutputStream("person.txt"));
		Person p1=new Person(1, "Deevanshu","21");
		Person p2=new Person(2,"Naveen","21");
		dout.writeObject(p1);
		
		dout.flush();
		dout.close();
		

		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
