package coding;

import java.math.BigInteger;


public class Fibbonaci {
	static int fibboanci(int n){
		if(n==0)
			return n;
		else if(n==1)
			return 1;
		else
			return fibboanci(n-1)+fibboanci(n-2);
	}
	public static void main(String[] args) {
		
		System.out.println(Fibbonaci.fibboanci(10));
		
		BigInteger fact= new BigInteger("1");
		BigInteger inc= new BigInteger("1");
		for(int i=1;i<=100;i++){
			fact=fact.multiply(inc);
			inc=inc.add(BigInteger.ONE);
		}
		
		System.out.println(fact);
		
		
	}
}
