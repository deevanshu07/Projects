class MyException extends Exception {
	public MyException(String message) {
		System.out.println(message);
	}
}

public class CustomException {
	public static void main(String[] args) throws MyException {

		try{
			int result=10/0;
		}
		catch(Exception e){
			throw new MyException(e.getMessage());
		}
	}
}
