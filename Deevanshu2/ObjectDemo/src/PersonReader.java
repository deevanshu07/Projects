import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;


@SuppressWarnings("serial")
public class PersonReader implements Serializable{


	public static void main(String[] args) 
	{
		ObjectInputStream din=null;
		
		try
		{
			din=new ObjectInputStream(new FileInputStream("person.txt"));
			
			Person person=(Person)din.readObject();
			
			System.out.println(person+"\n");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
