package coding;

public class BinaryToDecimal {
	public static void main(String[] args) {

		System.out.println(Integer.parseInt("1111100", 2));
		int num = 1111100;
		int decimal=0;
		int module=0;
		while(num>0){
			decimal+=(num%10)*Math.pow(2,module);
			num=num/10;
			module++;
		}		
		System.out.println(decimal);	
	}
}
