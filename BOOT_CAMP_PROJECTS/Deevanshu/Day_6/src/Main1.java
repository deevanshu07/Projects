
public class Main1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Data data = new Data();
		
		data.setValue(100);
		
		IncThread inc = new IncThread(data);
		DecThread dec = new DecThread(data);
		
		
		
		Thread in = new Thread(inc);
		Thread de = new Thread(dec);
		
		in.start();
		de.start();
		
	}

}
