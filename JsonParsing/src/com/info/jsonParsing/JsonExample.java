package com.info.jsonParsing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.schneider.utilities.Utility;

public class JsonExample {

	public static void main(String[] args) throws IOException, JSONException {

		Properties prop = new Properties();
		InputStream input = new FileInputStream("config.properties");
		prop.load(input);
		
		JSONObject jsonObject = new JSONObject(
				readJsonFile("C:\\Users/deevanshu.mahajan/Desktop/search.json"));

	String json = new Gson().toJson(jsonObject);
	json=new Utility().getModifyJson(json);
	System.out.println(json);
	

	
		JSONObject obj;
/*		// For changing Body tag
		if(!prop.getProperty("response").equals("")){
		String responseString[] = prop.getProperty("response").split(",");
		for (int i = 0; i < docs.length(); i++) {
			JSONObject js = docs.getJSONObject(i);
			JSONObject jsom = new JSONObject();
			for (int j = 0; j < responseString.length; j++) {
				if (js.has(responseString[j])) {
					jsom.put(responseString[j], js.get(responseString[j]));
					js.remove(responseString[j]);
				}
				js.put("body", jsom);
			}
		}
		}
		// For changing highlightning tag

		
		if (jsonObject.has("highlighting")) {
			String highlightString[] = prop.getProperty("highlightning").split(",");
			JSONObject highlighting = jsonObject.getJSONObject("highlighting");
			for (Iterator<?> iter = highlighting.keySet().iterator(); iter.hasNext();) {
				obj = new JSONObject();
				String key = (String) iter.next();	
				for (int i = 0; i < highlightString.length; i++) {		
					if (highlighting.getJSONObject(key).has(highlightString[i]))			
						obj.put(highlightString[i], highlighting.getJSONObject(key).get(highlightString[i]));
					else
						obj.put(highlightString[i], "[]");					
				}
				highlighting.put(key, obj);
			}


		}
		if (jsonObject.has("facet_counts")) {
			JSONObject facet_fields = jsonObject.getJSONObject("facet_counts").getJSONObject("facet_fields");
			JSONArray finalArray = new JSONArray();

			for (Iterator<?> iter = facet_fields.keySet().iterator(); iter.hasNext();) {
				obj = new JSONObject();
				String key = (String) iter.next();
				JSONArray valueArray = facet_fields.getJSONArray(key);
				obj.put("field", key);
				JSONArray array = new JSONArray();
				JSONObject childArray = null;
				for (int i = 0; i < valueArray.length() - 1; i++) {
					childArray = new JSONObject();
					if (valueArray.length() % 2 == 0) {
						childArray.put("name", valueArray.get(i));
						childArray.put("count", valueArray.get(++i));
						array.put(childArray);
					}
				}
				obj.put("children", array);
				finalArray.put(obj);
			}
			jsonObject.getJSONObject("facet_counts").put("facet_fields", finalArray);
		}*/
		
/*		//System.out.println(jsonObject);
		if (jsonObject.has("facet_counts")) {
			
			JSONObject facet_fields = jsonObject.getJSONObject("facet_counts").getJSONObject("facet_fields");
			JSONArray finalArray = new JSONArray();

			for (Iterator<?> iter = facet_fields.keys().iterator(); iter.hasNext();) {
				obj = new JSONObject();
				String key = (String) iter.next();
				JSONArray valueArray = facet_fields.getJSONArray(key);
				obj.put("field", key);
				JSONArray array = new JSONArray();
				JSONObject childArray = null;
				for (int i = 0; i < valueArray.length() - 1; i++) {
					childArray = new JSONObject();
					if (valueArray.length() % 2 == 0) {
						childArray.put("name", valueArray.get(i));
						childArray.put("count", valueArray.get(++i));
						array.put(childArray);
					}
				}
				obj.put("children", array);
				finalArray.put(obj);				
			}
			jsonObject.getJSONObject("facet_counts").put("facet_fields", finalArray);
		}
		
		System.out.println(jsonObject);*/
		

	}

	public static String readJsonFile(String filePath) {
		String jsonString = "";
		try (BufferedReader br = new BufferedReader(new FileReader(filePath));) {
			File file = new File(filePath);
			if (file.exists()) {
				String sCurrentLine;
				while ((sCurrentLine = br.readLine()) != null) {
					jsonString = jsonString + sCurrentLine;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonString;
	}
	
}
