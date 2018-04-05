package coding;
public class SortedString {
	public static void main(String[] args) {

		String str = "mahajan";
		String n="";
		char ch[] = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {

			for (int j = i+1; j < ch.length; j++) {
				if(ch[i]>=ch[j])
                {
                    char m=ch[i];
                    ch[i]=ch[j];
                    ch[j]=m;
                }
			}
			n=n+ch[i];
		}
		
		System.out.println(n);

	}
}
