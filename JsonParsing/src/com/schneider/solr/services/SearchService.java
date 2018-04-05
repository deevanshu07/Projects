package com.schneider.solr.services;

import java.io.IOException;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.NoOpResponseParser;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.common.util.NamedList;
import org.json.JSONObject;

import com.schneider.solr.analyticsLog.AnalyticsLog;
import com.schneider.solr.resourcesLoader.LoadResource;
import com.schneider.utilities.DBLayer;
import com.schneider.utilities.JSONFormatter;
import com.schneider.utilities.TimeHelper;
import com.schneider.utilities.Utility;

/**
 * 
 * @author Infogain 15-Jul-2016
 * Search Service designed to integrate the SOLR service with UI.
 *     
 */
@Path("services")
public class SearchService {

	private static Logger logger = Logger.getLogger(SearchService.class.getName());
	AnalyticsLog analyticsLog = new AnalyticsLog();
	Utility utility = new Utility();
	HttpSolrClient solr = null;
	//CloudSolrClient solr = null;
	SolrQuery queryObj = null;

	/**
	 * 
	 * @param query (Search text eg. query="search String like Scheinder new docs") non Mandatory field has blank default value
	 * @param filterQuery (Refining search results eg. filterQuery=entitlements:(WonderwareRegistered OR WonderwareCustomer) where entitlements is a field)
	 * @param sortField (used for providing the field on which user wants to apply the sorting logic like date or relevance)
	 * @param sortOrder (desc or asc)
	 * @param solrStart (start index value of the solr search)
	 * @param searchId  (Unique id for the user tracking related to session tracking)
	 * @param noOfResults (No. of records to be present to the user per page default value is 25)
	 * @param SAMAccountName  (Unique name for the session value)
	 * @param wwTechSupportID (Unique support id related to session tracking)
	 * @param sessionId (Unique session id)
	 * @param dateRangeMappingValue (date based filter used by SOLR)
	 * @return
	 */
	@Path("searchService")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getSearchResponse(
			@DefaultValue("*") @QueryParam("query") String query,
			@DefaultValue("") @QueryParam("filterQuery") String filterQuery,
			@DefaultValue("") @QueryParam("sortField") String sortField,
			@DefaultValue("") @QueryParam("sortOrder") String sortOrder,
			@DefaultValue("0") @QueryParam("solrStart") int solrStart,
			@QueryParam("searchId") String searchId,
			@DefaultValue("25") @QueryParam("noOfResults") int noOfResults,
			@DefaultValue("0") @QueryParam("dateRangeMappingValue") int dateRangeMappingValue,
			@DefaultValue("json") @QueryParam("wt") String wt , @QueryParam("rq") String rq) {
		System.out.println(":ENter ");
		TimeHelper.serviceStartTime("Search Service");
		logger.info("Inside getSearchResponse");
		logger.info("Search service parameters");
		logger.info("query : "+query);
		logger.info("filterQuery : "+filterQuery);
		logger.info("sortField : "+sortField);
		logger.info("sortOrder : "+sortOrder);
		logger.info("solrStart : "+solrStart);
		logger.info("searchId : "+searchId);
		logger.info("noOfResults : "+noOfResults);
		
		logger.info("dateRangeMappingValue : "+dateRangeMappingValue);
		logger.info("wt : "+wt);
		logger.info("rq : "+rq);
		String jsonResponse = null;
		JSONObject jsonResponseFormatted = null;
		try {
			String zkHost = LoadResource.solrUrl;
			solr = new HttpSolrClient(zkHost);
			//solr = new CloudSolrClient(zkHost);
			//solr.setDefaultCollection(LoadResource.cloudCoreName);
			queryObj = new SolrQuery();
			if(searchId!=null && !searchId.trim().equals(""))
			{
				String facetField =LoadResource.facetField;
				
				queryObj.setFields(LoadResource.fields);
				queryObj.setStart(solrStart);
				queryObj.setRows(noOfResults);
				queryObj.setParam("indent", true);
				queryObj.setFacet(true);
				
				if(facetField!="" && facetField.length()>0){
					String facetFieldArr[] = facetField.split(",");
					for(int i=0; i<facetFieldArr.length;i++){
						queryObj.addFacetField(facetFieldArr[i]);
					}
				}
				
				String facetQuery=LoadResource.facetQuery;
				if(facetQuery!="" && facetQuery.length()>0){
					String facetQueryArr[] = facetQuery.split(",");
					for(int i=0; i<facetQueryArr.length;i++){
						queryObj.addFacetQuery(facetQueryArr[i]);
					}
				}
				if(query.equals("*"))
					queryObj.setParam("q", query);
				else
					queryObj.setParam("q", query);
				if(sortField!=null && sortField.length()>0 && sortOrder!=null && sortOrder.length()>0){
					if (sortOrder.equals("asc"))
						queryObj.setSort(sortField, ORDER.asc);
					else
						queryObj.setSort(sortField, ORDER.desc);
					}
				//change for Entitlements filter mapping
				
				/*if(filterQuery!="" && filterQuery.length()>0){
					String filterQueryArr[] = filterQuery.split(" AND ");
					for(int i=0; i<filterQueryArr.length;i++){
						queryObj.addFilterQuery(filterQueryArr[i].trim());
					}
				}*/
				
				//new code//
				
				if(filterQuery!="" && filterQuery.length()>0){
					String filterQueryArr[] = filterQuery.split(" AND ");
					for(int i=0; i<filterQueryArr.length;i++){
						/*if(filterQueryArr[i].trim().contains("brand")){
							String brandArr[] = filterQueryArr[i].trim().split(":");
							String value = brandArr[1].trim();
							String brandValue = value.substring(value.indexOf("(")+1, value.indexOf(")"));
							queryObj.addFilterQuery("brand:("+brandValue.toUpperCase()+")");
						}
						else*/ 
						if(filterQueryArr[i].trim().contains("entitlements")){
							String entitlementsArr[] = filterQueryArr[i].trim().split(":");
							String value = entitlementsArr[1].trim();
							String entitlementsValue = value.substring(value.indexOf("(")+1, value.indexOf(")"));
							String mappedValue = LoadResource.getValue(entitlementsValue.trim());
							mappedValue = mappedValue.replaceAll(",", " OR ");
							queryObj.addFilterQuery("entitlements:("+mappedValue+")");
						}
						else{
							queryObj.addFilterQuery(filterQueryArr[i].trim());
						}
					}
				}
				// End new code
				if(dateRangeMappingValue==1){
					queryObj.addFilterQuery(LoadResource.lastMonths);
					}
				if(dateRangeMappingValue==2){
					queryObj.addFilterQuery(LoadResource.lastYear);
					}
				
				queryObj.setParam("wt",wt);
				if(rq!=null && "true".equals(rq))
				{
					String rqQ = "{!ltr model=lethiumModel reRankDocs=100 efi.user_query='"+query+"' }";
					queryObj.setParam("rq",rqQ);
				}
				
				logger.info("queryObj : "+queryObj);
				
				QueryRequest queryRequest = new QueryRequest(queryObj);
				NoOpResponseParser rawJsonResponseParser = new NoOpResponseParser();
				if("xml".equals(wt))
				{
					rawJsonResponseParser.setWriterType("xml");
				}else
					rawJsonResponseParser.setWriterType("json");
				queryRequest.setResponseParser(rawJsonResponseParser);
				NamedList<Object> resp = solr.request(queryRequest);
				jsonResponse = (String) resp.get("response");
				
				//System.out.println(jsonResponse);
				
				if("xml".equals(wt))
				{
					return Response.status(Response.Status.OK).entity(jsonResponse).type(MediaType.APPLICATION_XML).build();
				}
				
				/* Create Analytics Log */
				analyticsLog.createSearchAnatyticsLog(jsonResponse.toString(),searchId,"","","" );
				
				JSONFormatter formatter = new JSONFormatter();
				jsonResponseFormatted = formatter.formatJson(jsonResponse);
				
				/*if("xml".equals(wt))
				{
					TimeHelper.serviceEndTime("Search Service");
					TimeHelper.totalExecutionTime("Search Service");
					return Response.status(Response.Status.OK).entity(jsonResponse).type(MediaType.APPLICATION_XML).build();
					//return Response.status(Response.Status.OK).header("Content-Type", "application/xml;charset=UTF-8").entity(jsonResponse).build();
				}*/
				
				// to change the order of content source filter
				//jsonResponse = utility.getModifySolrResponse(jsonResponse);
		}
		else{
			throw new NullPointerException("Required parameter for service can't be 'null' ");
		}
		}catch (SolrServerException e) {
			e.printStackTrace();
			logger.error(e.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}catch (IOException e) {
			e.printStackTrace();
			logger.error(e.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}catch(BadRequestException e){
			e.printStackTrace();
			logger.error(e.toString());
			return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
		} 
		catch (Exception e) {
			e.printStackTrace();
			logger.error(e.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build();
		}
		finally {
			try {
				queryObj.clear();
				solr.commit();
				solr.close();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.toString());
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
			}
		}
		TimeHelper.serviceEndTime("Search Service");
		TimeHelper.totalExecutionTime("Search Service");
		return Response.status(Response.Status.OK).header("Content-Type", "application/json;charset=UTF-8").entity(jsonResponseFormatted.toString()).build();
	}
	
	
	@Path("hpsearchService")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getHPSearchResponse(@QueryParam("question") String question, @QueryParam("filter") String filter, @QueryParam("searchtext") String searchtext){
           String jsonResponse="";
           String filterType="",filterValue="";
           String flag="sp";
           //System.out.println("hfhdsjkfhkjsd----------->");
           logger.info("searchtext " + searchtext);
           try{
                  String zkHost = LoadResource.solrUrl;
                  //System.out.println("zkHost------->"+zkHost);
                  //System.out.println("filter---------->"+filter);
                  solr = new HttpSolrClient(zkHost);
                  //solr = new CloudSolrClient(zkHost);
                  //solr.setDefaultCollection(LoadResource.cloudCoreName);
                  queryObj = new SolrQuery();
                 if(searchtext==null || searchtext.trim().equals(""))
                 {
                	 jsonResponse = "Sorry... I couldn't find any information related to your question";
                	 return Response.status(Response.Status.OK).header("Content-Type", "application/json;charset=UTF-8").entity(jsonResponse).build();
                	 
                 } else
                 {
                	 if(searchtext.toLowerCase().contains("r-") || searchtext.toLowerCase().contains("report"))
                	 {
                		 logger.info("for report");
                		 flag="report";
                	 }
                	 else{
                		 logger.info("for sp");
                		 flag="sp";
                	 }
                 }
                  if(filter==null || filter.trim().equals("") )
	              {
                	  
                	  logger.info("filters null question is " + question);
                	  if(searchtext.toLowerCase().contains("how many"))
                	  {
                		  logger.info("run query for how many sp");
                		  
                		  
                		  
                		  
                	  }
                	  else if(searchtext.toLowerCase().contains("last quarter"))
                	  {
                		  boolean all = true;
                		  logger.info("run query for revenue sp");
                		  
                		  String test =  searchtext;
                		  String lastWord = test.substring(test.lastIndexOf(" ")+1);
                		  logger.info("last word is "+ lastWord);
                		  
                		  if("laptop".equalsIgnoreCase(lastWord) || "laptops".equalsIgnoreCase(lastWord))
                		  {
                			  all=false;
                			  DBLayer db = new DBLayer();
                    		  float result = db.getRevenue(question,1);
                    		  if(result ==0)
	  							{
	  								jsonResponse = "Sorry... I am unable to find the required data";
	  							}
	  							else {
	  							jsonResponse = "$"+String.valueOf(result);
	  							}
                    		  	return Response.status(Response.Status.OK).header("Content-Type", "application/json;charset=UTF-8").entity(jsonResponse).build();
                		  }
                		  else if("printer".equalsIgnoreCase(lastWord) || "printers".equalsIgnoreCase(lastWord))
                		  {
                			  all=false;
                			  DBLayer db = new DBLayer();
                    		  float result = db.getRevenue(question,2);
                    		  if(result ==0)
	  							{
	  								jsonResponse = "Sorry... I am unable to find the required data";
	  							}
	  							else {
	  							jsonResponse = "$"+String.valueOf(result);
	  							}
                    		  	return Response.status(Response.Status.OK).header("Content-Type", "application/json;charset=UTF-8").entity(jsonResponse).build();
                		  }
                		  else if("scanner".equalsIgnoreCase(lastWord) || "scanners".equalsIgnoreCase(lastWord))
                		  {
                			  all=false;
                			  DBLayer db = new DBLayer();
                    		  float result = db.getRevenue(question,3);
                    		  if(result ==0)
	  							{
	  								jsonResponse = "Sorry... I am unable to find the required data";
	  							}
	  							else {
	  							jsonResponse = "$"+String.valueOf(result);
	  							}
                    		  	return Response.status(Response.Status.OK).header("Content-Type", "application/json;charset=UTF-8").entity(jsonResponse).build();
                		  }
                		  if(all) {
	                		  DBLayer db = new DBLayer();
	                		  float result = db.getRevenueLastQuarter(question);
	                		  if(result ==0)
								{
									jsonResponse = "Sorry... I am unable to find the required data";
								}
								else {
								jsonResponse = "$"+String.valueOf(result);
								}
	                		  return Response.status(Response.Status.OK).header("Content-Type", "application/json;charset=UTF-8").entity(jsonResponse).build();
                		  }
                	  }
                	  
                	  Utility util = new Utility();
                	  queryObj.setParam("q", question.trim());
	                  queryObj.addFilterQuery("dS:SP");
	                  queryObj.setParam("indent", true);
	                  queryObj.setParam("fl", "title,url,id");
	                  
	                  logger.info("queryObj : "+queryObj);
	                  
	                  QueryRequest queryRequest = new QueryRequest(queryObj);
	                  NoOpResponseParser rawJsonResponseParser = new NoOpResponseParser();
	                  rawJsonResponseParser.setWriterType("json");
	                  queryRequest.setResponseParser(rawJsonResponseParser);
	                  NamedList<Object> resp = solr.request(queryRequest); 
	                  jsonResponse = (String) resp.get("response");
	                  
	                  //System.out.println("jsonresponse 1 ------------ " + jsonResponse);
	                  
	                  //jsonResponse = util.getModifyJson(jsonResponse);
	                  //System.out.println("JSON response is " + StringEscapeUtils.unescapeJava(jsonResponse));
                	 
	              }
                  else
					{
		
						logger.info("inside else - question is " + question.trim() + " searchterm " + searchtext);
		
						if (filter.trim().contains(",")) {
							String filerParameters[] = filter.trim().split(",");
							// System.out.println("----------->"+filerParameters.length);
							for (int i = 0; i < filerParameters.length; i++) {
		
								String filerParameter[] = filerParameters[i].trim().split("=");
								filterType = filterType + filerParameter[0].trim() + ",";
								filterValue = filterValue + filerParameter[1].trim() + ",";
							}
							filterType = filterType.substring(0, filterType.length() - 1);
							filterValue = filterValue.substring(0, filterValue.length() - 1);
						} else {
							String filerParameter[] = filter.trim().split("=");
							filterType = filerParameter[0].trim();
							filterValue = filerParameter[1].trim();
						}
						
						if("report".equalsIgnoreCase(flag)){
						jsonResponse = "http://50.202.96.113:8081/SalesReport/report?question=" + question.trim()
								+ "&filterType=" + filterType + "&filterValue=" + filterValue;
						}
						else{
							
							logger.info(filterType + " value "+ filterValue + "  question  " + question);
							
							if(question.toLowerCase().contains("of"))
							{
								question = question.replace("of", "");
							}
							if(question.toLowerCase().contains("for"))
							{
								question = question.replace("for", "");
							}
							
							logger.info("new question is " + question);
							
							if(searchtext.toLowerCase().contains("average"))
							{
								logger.info("run average query here");
								
								
								DBLayer db = new DBLayer();
								float result = db.getAverage(filterType, filterValue,question.trim());
								if(result ==0)
								{
									jsonResponse = "Sorry... I am unable to find the required data";
								}
								else {
								jsonResponse = "$"+String.valueOf(result);
								}
								return Response.status(Response.Status.OK).header("Content-Type", "application/json;charset=UTF-8").entity(jsonResponse).build();
								
							}
							else if(searchtext.toLowerCase().contains("how many") || searchtext.toLowerCase().contains("number of"))
							{
								logger.info("run count query here");
								DBLayer db = new DBLayer();
								int count = db.getCount(filterType, filterValue,question.trim());
								if(count ==0)
								{
									jsonResponse = "Sorry... I am unable to find the required data";
								}
								else {
									jsonResponse = String.valueOf(count);
								}
								return Response.status(Response.Status.OK).header("Content-Type", "application/json;charset=UTF-8").entity(jsonResponse).build();
							}
							/*else if (searchtext.toLowerCase().contains("revenue"))
							{
								logger.info("run revenue query here");
							}*/
							
							
						}
							
						
					}
	        	   	  	        	   	 
	             
           }catch (SolrServerException e) {
                  e.printStackTrace();
                  logger.error(e.toString());
                  return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
           }catch (IOException e) {
                  e.printStackTrace();
                  logger.error(e.toString());
                  return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
           }catch(BadRequestException e){
                  e.printStackTrace();
                  logger.error(e.toString());
                  return Response.status(Response.Status.BAD_REQUEST).entity(e).build();
           } 
           catch (Exception e) {
                  e.printStackTrace();
                  logger.error(e.toString());
                  return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build();
           }
           finally {
                  try {
                        queryObj.clear();
                        solr.commit();
                        solr.close();
                  } catch (Exception e) {
                        e.printStackTrace();
                        logger.error(e.toString());
                        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
                  }
           }
           
   return Response.status(Response.Status.OK).header("Content-Type", "application/json;charset=UTF-8").entity(jsonResponse).build();
    //return Response.status(Response.Status.OK).header("Content-Type", "application/json;charset=UTF-8").entity(StringEscapeUtils.unescapeJava(jsonResponse).replaceAll("/\\n/g","")).build();
    }

	
	
	
	
	/**
	 * @author Infogain 15-Jul-2016
	 * This is click through service (capture click through) used to track the event for analytic.
	 * @param linkPosition (index value of record on the search page.)
	 * @param answer (answer against a search query)
	 * @param docUrl (url of the answer)
	 * @param searchId (unique index value)
	 * @return
	 */
	@Path("clickThroughService")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response answerClicked(
		@DefaultValue("-1")	@QueryParam("linkPosition") int linkPosition, 
		@QueryParam("title") String title, 
		@QueryParam("docId") String docId, 
		@QueryParam("searchId") String searchId) {
		logger.info("Inside answerClicked");
		logger.info("linkPosition :"+linkPosition);
		logger.info("title : "+title);
		logger.info("docId : "+docId);
		logger.info("searchId : "+searchId);
		
		String status ="success";
		try {
			
			System.out.println("searchId " + searchId);
			System.out.println("linkPosition " + linkPosition);
			System.out.println("title " + title);
			System.out.println("docId " + docId);
			
			
			if(searchId!=null && linkPosition!=-1 && title!=null && docId!=null && !searchId.trim().equals("") && !title.trim().equals("") && !docId.trim().equals("")){
				analyticsLog.createClickThroghAnalyticsLog(linkPosition, title, java.net.URLDecoder.decode(docId.trim(), "UTF-8"), searchId);
			}
		    else{
				throw new NullPointerException(" Required parameter for service can't be 'null' ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "Fail";
			logger.error(e.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(status).build();
		}
		return Response.status(Response.Status.OK).entity(status).build();
	}
	
	@Path("typeAheadService")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response typeAheadAutoComplete(@QueryParam("query") String query, @QueryParam("brand") String brand, @QueryParam("entitlements") String entitlements){
		logger.info("In Side typeAheadAutoComplete");
		logger.info("query : "+query);
		logger.info("brand : "+brand);
		logger.info("entitlements : "+entitlements);
		String jsonResponse = null;
		try{
			brand = brand!=null?brand.trim():"";
			entitlements = entitlements!=null?entitlements.trim():"";
			if(query!=null && query.trim().length()>0){
			String zkHost = LoadResource.solrUrl;
			solr = new HttpSolrClient(zkHost);
			//solr = new CloudSolrClient(zkHost);
			//solr.setDefaultCollection(LoadResource.cloudCoreName);
			queryObj = new SolrQuery();
			queryObj.setParam("q", query.trim());
			queryObj.setParam("qf", "title");
			queryObj.addFacetField("kbType");
			queryObj.setRows(0);
			
			if(entitlements!=null && entitlements!="" && brand!=null && brand.trim().length()>0){
				String mappedValue = LoadResource.getValue(entitlements.trim());
				mappedValue = mappedValue.replaceAll(",", " OR ");
				queryObj.addFilterQuery("entitlements:("+mappedValue+")");
				queryObj.addFilterQuery("brand:(\""+brand+"\")");
			}
			queryObj.setParam("indent", true);
			queryObj.setFacet(true);
			queryObj.setParam("defType", "edismax");
			queryObj.setFacetMinCount(0);
			
			logger.info("Type ahead solr query : "+queryObj);
			
			QueryRequest queryRequest = new QueryRequest(queryObj);
			NoOpResponseParser rawJsonResponseParser = new NoOpResponseParser();
			rawJsonResponseParser.setWriterType("json");
			queryRequest.setResponseParser(rawJsonResponseParser);
			NamedList<Object> resp = solr.request(queryRequest);
			jsonResponse = (String) resp.get("response");
			
			}
		}catch(Exception e){
			logger.error(e.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build();
		}finally{
			try {
				queryObj.clear();
				solr.commit();
				solr.close();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.toString());
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
			}
		}
		return Response.status(Response.Status.OK).header("Content-Type", "application/json;charset=UTF-8").entity(jsonResponse).build();
	}
	
	@Path("suggestionService")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response typeAheadSuggestion(@QueryParam("suggest.q") String query, @QueryParam("suggest.cfq") String entitlements){
		logger.info("In Side typeAheadSuggestion");
		logger.info("suggest.q : "+query);
		logger.info("suggest.cfq : "+entitlements);
		String jsonResponse = null;
		try{
			entitlements = entitlements!=null?entitlements.trim():"";
			if(query!=null && query.length()>0){
			String zkHost = LoadResource.solrUrl;
			solr = new HttpSolrClient(zkHost);
			//solr = new CloudSolrClient(zkHost);
			//solr.setDefaultCollection(LoadResource.cloudCoreName);
			queryObj = new SolrQuery();
			queryObj.setRequestHandler("/suggest");
			queryObj.setParam("suggest.q", query.trim());
			if(entitlements!=null && entitlements!=""){
				String mappedValue = LoadResource.getValue(entitlements.trim());
				mappedValue = mappedValue.replaceAll(",", " OR ");
				queryObj.setParam("suggest.cfq","("+mappedValue+")");
			}
			queryObj.setParam("indent", true);
			logger.info(" Type ahead suggestion solr query : "+queryObj);
			
			QueryRequest queryRequest = new QueryRequest(queryObj);
			NoOpResponseParser rawJsonResponseParser = new NoOpResponseParser();
			rawJsonResponseParser.setWriterType("json");
			queryRequest.setResponseParser(rawJsonResponseParser);
			NamedList<Object> resp = solr.request(queryRequest);
			jsonResponse = (String) resp.get("response");
			}
		}catch(Exception e){
			logger.error(e.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build();
		}
		finally{
			try {
				queryObj.clear();
				solr.commit();
				solr.close();
			} catch (Exception e){
				e.printStackTrace();
				logger.error(e.toString());
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
			}
		}
		return Response.status(Response.Status.OK).header("Content-Type", "application/json;charset=UTF-8").entity(jsonResponse).build();
	}
	// Test New Suggestion//
	@Path("suggestionServiceTest")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response typeAheadSuggestionTest(@QueryParam("prefix") String prefix, @QueryParam("entitlements") String entitlements){
		logger.info("In Side typeAheadSuggestion");
		logger.info("prefix : "+prefix);
		logger.info("entitlements : "+entitlements);
		String jsonResponse = null;
		try{
			entitlements = entitlements!=null?entitlements.trim():"";
			if(prefix!=null && prefix.length()>0){
			String zkHost = LoadResource.solrUrl;
			solr = new HttpSolrClient(zkHost);
			//solr = new CloudSolrClient(zkHost);
			//solr.setDefaultCollection(LoadResource.cloudCoreName);
			queryObj = new SolrQuery();
			queryObj.setParam("q","*");
			queryObj.setFacet(true);
			queryObj.addFacetField(LoadResource.getValue("suggestFacetField").trim());
			queryObj.setFacetPrefix(prefix.trim().toLowerCase());
			queryObj.setFacetMinCount(1);
			queryObj.setFacetLimit(Integer.parseInt(LoadResource.getValue("suggestFacetLimit").trim()));
			queryObj.setRows(0);
			if(entitlements!=null && entitlements!=""){
				String mappedValue = LoadResource.getValue(entitlements.trim());
				mappedValue = mappedValue.replaceAll(",", " OR ");
				queryObj.addFilterQuery("entitlements:("+mappedValue+")");
			}
			queryObj.setParam("indent", true);
			logger.info(" Type ahead suggestion test solr query : "+queryObj);
			
			QueryRequest queryRequest = new QueryRequest(queryObj);
			NoOpResponseParser rawJsonResponseParser = new NoOpResponseParser();
			rawJsonResponseParser.setWriterType("json");
			queryRequest.setResponseParser(rawJsonResponseParser);
			NamedList<Object> resp = solr.request(queryRequest);
			jsonResponse = (String) resp.get("response");
			}
		}catch(Exception e){
			logger.error(e.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build();
		}
		finally{
			try {
				queryObj.clear();
				solr.commit();
				solr.close();
			} catch (Exception e){
				e.printStackTrace();
				logger.error(e.toString());
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
			}
		}
		return Response.status(Response.Status.OK).header("Content-Type", "application/json;charset=UTF-8").entity(jsonResponse).build();
	}
	/////
}
