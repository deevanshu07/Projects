import java.io.FileReader;


public class CharwiteDemo {

	public static void main(String[] args) 
	{
		FileReader fr;
		try
		{
			fr= new FileReader("characterReader.txt");
			int data=0;
			while((data=fr.read())!=-1)
			{
				char charData=(char)data;
				System.out.print(charData);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error occured");
		}

	}

}
