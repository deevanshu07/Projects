interface A1{}
interface B1{}
interface C1 extends A1, B1
{}


class AB
{
	void display3(){}
}

interface A
{
	void display();
	int i=10;
}
interface C
{
	void display1();
}



 class B extends AB implements A, C,C1
{
	 
	 
	public void display()
	{
		System.out.println("Interface1");
	}
	
	public void display1()
	{
		System.out.println("Interface2");
	}
	
	
	void display3()
	{
		System.out.println("Extending Method");
	}
	
}
public class interface_Demo 
{
	
	public static void main(String[] args) 
	{
	
		B obj = new B();
		C obj1 = new B();
		obj.display();
		obj1.display1();
		
		

	}

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                