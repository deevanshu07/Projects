package com.schneider.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.schneider.solr.model.FacetModel;
import com.schneider.solr.model.ResponseModel;
import com.schneider.solr.resourcesLoader.LoadResource;


public class Utility {
	List<FacetModel> facetList = new ArrayList<FacetModel>();
	List<String> facetsList = new ArrayList<String>();
	JSONObject jsonObject = null;
	JSONObject response = null;
	JSONObject highlighting =null;
	JSONObject newJson = null;
	List<ResponseModel> responseList = new ArrayList<ResponseModel>();
	public String getModifySolrResponse(String jsonResponse){
		try{
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(jsonResponse);

			jsonObject = (JSONObject) obj;

			JSONObject responseFacets =  (JSONObject) jsonObject.get("facet_counts");
			JSONObject facetObject= (JSONObject)responseFacets.get("facet_fields");
			JSONObject responseHdr =  (JSONObject) jsonObject.get("responseHeader");
			JSONObject params=(JSONObject)responseHdr.get("params");
			try{
			JSONArray facetsArray =(JSONArray) params.get("facet.field");
			
			JSONArray facetsArr=(JSONArray)facetObject.get("kbType");
			
			Iterator<?> facetIterator = facetsArr.iterator();
			facetsList = new ArrayList<String>();
			while (facetIterator.hasNext()) 
			{
				FacetModel facetModel = new FacetModel();
				Object facet=facetIterator.next();
				Long count =(Long)facetIterator.next();
				if(facet.toString().trim().equals("Knowledge Base")){
					facetModel.setFacetName(facet.toString().trim());
					facetModel.setFacetCount(count);
					facetModel.setPosition(Integer.parseInt(LoadResource.Knowledge_Base_position));
				}
				if(facet.toString().trim().equals("Product Documentation")){
					facetModel.setFacetName(facet.toString().trim());
					facetModel.setFacetCount(count);
					facetModel.setPosition(Integer.parseInt(LoadResource.Product_Documentation_position));
				}
				if(facet.toString().trim().equals("Downloads")){
					facetModel.setFacetName(facet.toString().trim());
					facetModel.setFacetCount(count);
					facetModel.setPosition(Integer.parseInt(LoadResource.Downloads_position));
				}
				if(facet.toString().trim().equals("Security Central")){
					facetModel.setFacetName(facet.toString().trim());
					facetModel.setFacetCount(count);
					facetModel.setPosition(Integer.parseInt(LoadResource.Security_Central_position));
				}
				if(facet.toString().trim().equals("Security Updates")){
					facetModel.setFacetName(facet.toString().trim());
					facetModel.setFacetCount(count);
					facetModel.setPosition(Integer.parseInt(LoadResource.Security_Updates_position));
				}
				if(facet.toString().trim().equals("Videos")){
					facetModel.setFacetName(facet.toString().trim());
					facetModel.setFacetCount(count);
					facetModel.setPosition(Integer.parseInt(LoadResource.Videos_position));
				}
				if(facet.toString().trim().equals("Communities")){
					facetModel.setFacetName(facet.toString().trim());
					facetModel.setFacetCount(count);
					facetModel.setPosition(Integer.parseInt(LoadResource.Communities_position));
				}
				if(facet.toString().trim().equals("eLearning")){
					facetModel.setFacetName(facet.toString().trim());
					facetModel.setFacetCount(count);
					facetModel.setPosition(Integer.parseInt(LoadResource.eLearning_position));
				}
				if(facet.toString().trim().equals("Other")){
					facetModel.setFacetName(facet.toString().trim());
					facetModel.setFacetCount(count);
					facetModel.setPosition(Integer.parseInt(LoadResource.Other_position));
				}
				facetList.add(facetModel);
			}
			Collections.sort(facetList, new Comparator<FacetModel>() {
				@Override
				public int compare(FacetModel o1, FacetModel o2) {
					return o1.getPosition() - o2.getPosition();
				}
			});
			}catch(Exception e){
				e.printStackTrace();
			}
			String json = new Gson().toJson(facetList);
			facetObject.put("kbType",json);
			
		}catch(Exception e){
			
		}
		return jsonObject.toString();
	}
	
	public String getModifyJson(String jsonResponse){
		try{
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(jsonResponse);

			jsonObject = (JSONObject) obj;
			response=(JSONObject)jsonObject.get("response");
			System.out.println(response);
			highlighting=(JSONObject)jsonObject.get("highlighting");
			newJson = new JSONObject();
			JSONArray docArray = (JSONArray)response.get("docs");
			Iterator<?> docArrayItr = docArray.iterator();
			while(docArrayItr.hasNext()){
				ResponseModel responseModel = new ResponseModel();
				JSONObject docObj = (JSONObject) docArrayItr.next();
				System.out.println("----------->"+docObj.get("title"));
				responseModel.setTitle(docObj.get("title").toString());
				responseModel.setId(docObj.get("id").toString());
				JSONObject content =(JSONObject) highlighting.get(docObj.get("id").toString());
				responseModel.setExcerpt(content.get("content").toString());
				responseList.add(responseModel);
			}
			
			//newJson.put("response", response);
			//newJson.put("highlighting", highlighting);
			String json = new Gson().toJson(responseList);
			newJson.put("response",json );
			
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			
		
		return newJson.toString();
	}

}
