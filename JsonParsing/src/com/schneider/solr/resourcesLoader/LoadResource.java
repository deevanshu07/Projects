package com.schneider.solr.resourcesLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class LoadResource
{
	public static String solrUrl = "";
	public static String lastYear = "";
	public static String lastMonths= "";
	public static String facetField = "";
	public static String logPropertiesUrl="";
	public static String logPropertiesUrl_2="";
	public static String logPropertiesUrl_3="";
	public static String logPropertiesUrl_4="";
	public static String title="";
	public static String url="";
	public static String answerType="";
	public static String locale="";
	public static String fields="";
	public static String cloudCoreName="";
	public static String facetQuery="";
	public static String Knowledge_Base_position = "";
	public static String Product_Documentation_position = "";
	public static String Downloads_position = "";
	public static String Security_Central_position = "";
	public static String Security_Updates_position = "";
	public static String Videos_position = "";
	public static String Communities_position = "";
	public static String eLearning_position = "";
	public static String Other_position = "";
	public static String suggestFacetField = "";
	public static String suggestFacetLimit = "";
	public static String jsonResponseFields ="";
	public static String jsonHighlightFields = "";
	
	
	
	private static Properties prop =null;
	private static Logger logger = Logger.getLogger(LoadResource.class.getName());
	
	public static void loadProperites(String ResourcePath){
		prop= new Properties();
		InputStream resourceFile =null;
		try {
			resourceFile=new FileInputStream(ResourcePath);
			prop.load(resourceFile);
			if(prop.getProperty("solrUrl")!=null && prop.getProperty("solrUrl").length()>0){
				solrUrl = prop.getProperty("solrUrl").trim();
			}else{
				throw new Exception("Key 'solrUrl' is empty or not define in resource file");
			}
			if(prop.getProperty("facetField")!=null && prop.getProperty("facetField").length()>0){
				facetField = prop.getProperty("facetField").trim();
			}else{
				//throw new Exception("Key 'facetField' is empty or not define in resource file");
			}
			if(prop.getProperty("logPropertiesUrl")!=null && prop.getProperty("logPropertiesUrl").length()>0){
				logPropertiesUrl = prop.getProperty("logPropertiesUrl").trim();
			}else{
				throw new Exception("Key 'logPropertiesUrl' is empty or not define in resource file");
			}
			if(prop.getProperty("logPropertiesUrl_2")!=null && prop.getProperty("logPropertiesUrl_2").length()>0){
				logPropertiesUrl_2 = prop.getProperty("logPropertiesUrl_2").trim();
			}
			if(prop.getProperty("logPropertiesUrl_3")!=null && prop.getProperty("logPropertiesUrl_3").length()>0){
				logPropertiesUrl_3 = prop.getProperty("logPropertiesUrl_3").trim();
			}
			if(prop.getProperty("logPropertiesUrl_4")!=null && prop.getProperty("logPropertiesUrl_4").length()>0){
				logPropertiesUrl_4 = prop.getProperty("logPropertiesUrl_4").trim();
			}
			
			if(prop.getProperty("title")!=null && prop.getProperty("title").length()>0){
				title = prop.getProperty("title").trim();
			}
			if(prop.getProperty("url")!=null && prop.getProperty("url").length()>0){
				url = prop.getProperty("url").trim();
			}
			if(prop.getProperty("lastYear")!=null && prop.getProperty("lastYear").length()>0){
				lastYear = prop.getProperty("lastYear").trim();
			}
			if(prop.getProperty("lastMonths")!=null && prop.getProperty("lastMonths").length()>0){
				lastMonths = prop.getProperty("lastMonths").trim();
			}
			if(prop.getProperty("answerType")!=null && prop.getProperty("answerType").length()>0){
				answerType = prop.getProperty("answerType").trim();
			}
			if(prop.getProperty("locale")!=null && prop.getProperty("locale").length()>0){
				locale = prop.getProperty("locale").trim();
			}
			if(prop.getProperty("fields")!=null && prop.getProperty("fields").length()>0){
				fields = prop.getProperty("fields").trim();
			}
			if(prop.getProperty("jsonResponseFields")!=null && prop.getProperty("jsonResponseFields").length()>0){
				jsonResponseFields = prop.getProperty("jsonResponseFields").trim();
			}
			if(prop.getProperty("jsonHighlightFields")!=null && prop.getProperty("jsonHighlightFields").length()>0){
				jsonHighlightFields = prop.getProperty("jsonHighlightFields").trim();
			}
			
		} catch (Exception e) {
			logger.error(e.toString());
		}
		finally{
			try {
				resourceFile.close();
				resourceFile=null;
			} catch (IOException e){
				e.printStackTrace();
				logger.error(e.toString());
			}
			
		}
	}
	public static String getValue(String key){
		String value = null;
		try{
		if(prop.getProperty(key.trim())!=null && prop.getProperty(key.trim()).length()>0){
			value = prop.getProperty(key.trim()).trim();
		}else{
			throw new Exception("Key '"+key+"' is empty or not define in resource file");
		}
	}catch(Exception e){
		logger.error(e.toString());
		}
		return value;
	}
	
}

