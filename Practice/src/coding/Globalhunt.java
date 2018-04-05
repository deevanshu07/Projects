package coding;

import java.util.Formatter;
import java.util.Locale;


abstract class classA {
	public abstract void m1();
}

final class classB extends classA {
	@Override
	public void m1() {
		// TODO Auto-generated method stub
	}
}


public class Globalhunt {
	public static void main(String[] args) throws Exception {

		StringBuilder build = new StringBuilder("buffering");
		
		System.out.println(build.length());
		build.replace(2, 7, "BUFFER");
		System.out.println(build);
		System.out.println(build.length());
		build.delete(2, 4);
		System.out.println(build);
		String s=build.substring(1,5);
		System.out.println(s);
		
		String str="50.00";
		double myInt=Double.parseDouble(str);
		
		System.out.println(Math.nextAfter(10.22, 0.01));
		
		

		int num1=1;
		int num2=2;
		
		if(num1==num2 | num1!=num2){
			System.out.println("AAA");
		}
		
		
		
	}
}
