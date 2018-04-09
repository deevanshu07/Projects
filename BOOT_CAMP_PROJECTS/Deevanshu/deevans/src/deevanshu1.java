
class A
{
	A()
	{
		
		System.out.print("First chain"+"\n");
	}
	A(int i)
	
	{
	
	System.out.print("Second chain"+"\n");
	}
	
	A(String city)
	{
		this(4);
		System.out.print("Third chain"+"\n");
	}
	
	
}
	
	public class deevanshu1{


	public static void main(String[] args) {
		
		A a1 = new A();

	}

}
