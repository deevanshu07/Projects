package com.info.twc;

import java.net.URL;

import com.inquira.imwows.generated.ContentServices;
import com.inquira.imwows.generated.ContentServicesServiceLocator;
import com.inquira.imwows.generated.SecurityServices;
import com.inquira.imwows.generated.SecurityServicesServiceLocator;

public class Published {

	public static ContentServices contentService = null;
	public static SecurityServices securityService = null;
	public static void main(String[] args) {

		try {

			String repository = "TWC", imUrlSecurityService = "http://deevanshum:8226/imws/WebObjects/imws.woa/ws/SecurityService", imUrlContentService = "http://deevanshum:8226//imws/WebObjects/imws.woa/ws/ContentService";
			String GET_CONTENT_RECORD_MSG = "<CONTENT><CONTENTID></CONTENTID><DOCUMENTID>CK1</DOCUMENTID><LOCALECODE>en_US</LOCALECODE><LATEST_VERSION>true</LATEST_VERSION><INCREASEVIEWCOUNT>false</INCREASEVIEWCOUNT><ACTIVITY_TYPE></ACTIVITY_TYPE></CONTENT>";
			boolean isTokenValid = false;
			String securityToken = "";
			SecurityServicesServiceLocator securityServiceLocator = new SecurityServicesServiceLocator();
			URL webserviceURL = new URL("http://deevanshum:8226/imws/WebObjects/imws.woa/ws/SecurityService");
			securityService = securityServiceLocator
					.getSecurityServices(webserviceURL);
			securityToken = securityService
					.authenticate("<AUTHENTICATE><USER>deevanshu</USER><PASSWORD>Test01</PASSWORD><REPOSITORY_REFERENCE_KEY>"+repository+"</REPOSITORY_REFERENCE_KEY></AUTHENTICATE>");
			isTokenValid = securityService.isTokenValid(securityToken);
			System.out.println("Does TOken Valid\n" + isTokenValid);
			System.out.println(createContentService());
			String xmlDataForRecord = contentService.getContentRecord(securityToken,GET_CONTENT_RECORD_MSG);
			System.out.println("XML DATA FOR RECORD "+xmlDataForRecord);
			String newResponse = xmlDataForRecord.substring(xmlDataForRecord.indexOf("<CONTENT RECORDID="),
					xmlDataForRecord.indexOf("</CONTENT>")+"</CONTENT>".length());
			System.out.println(contentService.modifyContent(securityToken,
					newResponse, true));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static boolean createContentService(){
		boolean contentStatus = false;
		try {
			ContentServicesServiceLocator contentServiceLocator = new ContentServicesServiceLocator();
			URL webserviceURL = new URL("http://deevanshum:8226//imws/WebObjects/imws.woa/ws/ContentService");
			contentService = (ContentServices) contentServiceLocator
					.getContentServices(webserviceURL);
			contentStatus = true;
		} catch (Exception e) {
			System.out.println(("Error in creating ContentService Obj " + e.toString()));
		}
		return contentStatus;
	}
	private void printPrompt(String prompt) {
		System.out.println((prompt + " "));
		System.out.flush();
	}
}
