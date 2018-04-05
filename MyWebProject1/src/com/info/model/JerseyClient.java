package com.info.model;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class JerseyClient {

	public static void main(String[] args) throws ClassNotFoundException {

		/*Class c=Class.forName("User");
		Constructor con[]=c.getDeclaredConstructors();
	System.out.println(con);*/
		
		Date date = new Date();
		System.out.println(date);
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		Date date1 = calendar.getTime();
		System.out.println(date1);
		
	}
}
