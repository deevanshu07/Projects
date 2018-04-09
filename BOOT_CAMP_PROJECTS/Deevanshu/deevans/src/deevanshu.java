 class Test{
	int i=10;
	void display(){
		System.out.print(this.i);
	}
}
public class deevanshu {

	public static void main(String[] args) 
	{
		Test t1 = new Test();
		
		float f= 12.123456f;
		int a =12;
		byte b = 127;
		System.out.println("Result is="+(a+b+f));
		System.out.println("Value of i="+t1.i);
	}

}
