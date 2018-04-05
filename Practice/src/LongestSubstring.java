import java.util.Arrays;

public class LongestSubstring {

	public static void main(String[] args) {

		String str = "abcjtghijklrabcd";
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		String str1 = new String(charArray);
		System.out.println(str1);

		String str2="";
		for(int i=0;i<str1.length();i++){
		
			char ch=str1.charAt(i);
			if(ch!=' ')
				str2=str2+ch;
			str1=str1.replace(ch,' ');
		}
		
		
	}
}
