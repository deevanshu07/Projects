package com.schneider.solr.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;

import com.schneider.solr.resourcesLoader.LoadResource;

public class ContextListenerConfig implements ServletContextListener {
	
	

	@Override
	public void contextDestroyed(ServletContextEvent servletContext) {
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContext) {
		
		try{
			String ResourcePath = servletContext.getServletContext().getInitParameter("ResourcePath");
			LoadResource.loadProperites(ResourcePath);
			System.out.println("Intialize properties");
			final String path = LoadResource.logPropertiesUrl; //for invfoxapp210pv (Production) or invfoxapp213sv (Stage)
			System.out.println(LoadResource.jsonResponseFields);
			System.out.println(LoadResource.jsonHighlightFields);
			PropertyConfigurator.configure(path);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
	


}
