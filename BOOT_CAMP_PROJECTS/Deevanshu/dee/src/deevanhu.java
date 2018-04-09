import java.lang.*;
import java.util.Scanner;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import org.w3c.dom.stylesheets.StyleSheet;

class overLoading
{
	int sum(int a, int b)
	{
	int z=a+b;
	return z;
	}
	
	double sum(double a, double b)
	{
		double z= a+b;
		return z;
	}
	
	void sum(int a, String b)
	{
		System.out.println("Third method is called");
	}
}

public class deevanhu {


	public static void main(String[] args) 
	{
		overLoading obj = new overLoading();
		System.out.println("Sum of two integer numbers="+"\t"+obj.sum(2,3));
		System.out.println("Sum of two double numbers="+"\t"+obj.sum(12.4,32.6));
		obj.sum(12,"string");
		
		
}
}
