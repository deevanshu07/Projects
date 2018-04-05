package com.schneider.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class TimeHelper {
	private static final Logger logger = Logger.getLogger(TimeHelper.class);
	private static final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	private static String startTime;
	private static String endTime;
	public static long tokenStartTime;
	
	public static void serviceStartTime(String serviceName){
		Calendar calendar = Calendar.getInstance();
		tokenStartTime = new Date().getTime();
		startTime = format.format(calendar.getTimeInMillis());
		logger.info(""+ serviceName +" start time : "+ startTime);
	}
	
	public static void serviceEndTime(String serviceName){
		Calendar calendar = Calendar.getInstance();
		endTime = format.format(calendar.getTimeInMillis());
		logger.info(""+ serviceName +"  end time : "+ endTime);
	}
	
	public static void totalExecutionTime(String serviceName){
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = format.parse(startTime);
			d2 = format.parse(endTime);
			long diff = d2.getTime() - d1.getTime();
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			//long diffDays = diff / (24 * 60 * 60 * 1000);
			logger.info("Total execution time taken by  "+ serviceName +" : "+ diffHours + " hours, "+ diffMinutes + " minutes, and "+ diffSeconds + " seconds.");
		}catch (Exception e) {
			logger.error("Error while parsing the date"+ e.getMessage());
		}
	}

}
