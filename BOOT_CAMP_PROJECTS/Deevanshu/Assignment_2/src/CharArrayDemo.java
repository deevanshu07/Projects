import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CharArrayDemo {

	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		
		do
		{
			str =br.readLine();
			System.out.println("Read Successfully");
		}
		while(!str.equals("stop"));
		
		
	}

}
