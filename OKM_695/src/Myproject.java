class Generic
{
	public void display() {
	}
	public String name() {
		return null;
	}
}




class firstChild extends Generic{


}


public class Myproject {
	public static void main(String[] args) {
		String[] viewArr;
		String strmarket = "";
		String strViewTemp="";
		strViewTemp = strViewTemp.replace("+", "-");
		viewArr = strViewTemp.split("-");

		for (int i = 0; i < (viewArr.length) - 1; i++) {
			if (viewArr[i].indexOf("RC_") != -1) {
					strmarket = viewArr[i].replace("RC", "").replace("_", "");
					break;

				}
			}
		
		if(strViewTemp.equals("RC_CARE-RC_ALL_MARKETS"))
		{
			strmarket="ALLMARKETS";
		}
		if(strViewTemp.equals("RC_NORTHEAST-RC_TEXAS-RC_PACWEST-RC_NEW_YORK_CITY-RC_CAROLINAS-RC_MIDWEST-RC_CARE-RC_ALL_MARKETS")){
			strmarket="ALLMARKETS";
		}
		System.out.println(strmarket);

	}

}

