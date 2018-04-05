package coding;

public class RemovingDuplicates {
	public static void main(String[] args) {

		String originalString="Missicippi Deevanshu";
		
		String duplicate = "";
		char ch;
		for (int i = 0; i < originalString.length(); i++) {
		
			ch=originalString.charAt(i);
			if(ch!=' '){
				duplicate=duplicate+ch;
			}
			originalString=originalString.replace(ch, ' ');
			
		}
		
		System.out.println(duplicate);
	}
}
