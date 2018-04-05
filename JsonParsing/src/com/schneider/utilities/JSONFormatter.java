package com.schneider.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

import com.schneider.solr.resourcesLoader.LoadResource;

public class JSONFormatter {
public static void main(String[] args) {
	JSONObject jsonObject = new JSONObject(
			readJsonFile("C:\\Users/deevanshu.mahajan/Desktop/search.json"));
	
	String jsoString= jsonObject.toString();
	JSONObject json=new JSONFormatter().formatJson(jsoString);
/*	JSONArray BrandArray=json.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(0).getJSONArray("children");
	JSONArray ProductArray=json.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(1).getJSONArray("children");
	JSONArray DepartmentArray=json.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(2).getJSONArray("children");


	//Adding Department object
	json.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(0).remove("children");
	json.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(0).remove("field");
	json.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(0).put("field","Department");
	json.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(0).put("children", DepartmentArray);
	
	//Adding Brand object
	json.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(1).remove("children");
	json.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(1).remove("field");
	json.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(1).put("field", "Brand");
	json.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(1).put("children", BrandArray);
	
	//Adding Product object
	json.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(2).remove("children");
	json.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(2).remove("field");
	json.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(2).put("field", "Product");
	json.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(2).put("children", ProductArray);*/
		
	//System.out.println(json);

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

	public JSONObject formatJson(String jsonResponse) {

		JSONObject jsonObject = new JSONObject(jsonResponse);
		JSONArray docs = jsonObject.getJSONObject("response").getJSONArray(
				"docs");
		JSONObject obj;
		String responseString = LoadResource.jsonResponseFields;

		// For changing Body tag
		if (!responseString.equals("")) {

			String responseField[] = null;
			if (responseString != "" && responseString.length() > 0) {
				responseField = responseString.split(",");
			}

			for (int i = 0; i < docs.length(); i++) {
				JSONObject js = docs.getJSONObject(i);
				JSONObject jsom = new JSONObject();
				for (int j = 0; j < responseField.length; j++) {
					if (js.has(responseField[j])) {
						jsom.put(responseField[j], js.get(responseField[j]));
						js.remove(responseField[j]);
					}
					js.put("body", jsom);
				}
			}
		}
		// For changing highlightning tag

		if (jsonObject.has("facet_counts")) {
			JSONObject facet_fields = jsonObject.getJSONObject("facet_counts")
					.getJSONObject("facet_fields");
			JSONArray finalArray = new JSONArray();

			for (Iterator<?> iter = facet_fields.keySet().iterator(); iter
					.hasNext();) {
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
			jsonObject.getJSONObject("facet_counts").put("facet_fields",
					finalArray);
		}

		JSONArray BrandArray=jsonObject.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(0).getJSONArray("children");
		JSONArray ProductArray=jsonObject.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(1).getJSONArray("children");
		JSONArray DepartmentArray=jsonObject.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(2).getJSONArray("children");


		//Adding Department object
		jsonObject.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(0).remove("children");
		jsonObject.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(0).remove("field");
		jsonObject.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(0).put("field","Department");
		jsonObject.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(0).put("children", DepartmentArray);
		
		//Adding Brand object
		jsonObject.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(1).remove("children");
		jsonObject.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(1).remove("field");
		jsonObject.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(1).put("field", "Brand");
		jsonObject.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(1).put("children", BrandArray);
		
		//Adding Product object
		jsonObject.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(2).remove("children");
		jsonObject.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(2).remove("field");
		jsonObject.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(2).put("field", "Product");
		jsonObject.getJSONObject("facet_counts").getJSONArray("facet_fields").getJSONObject(2).put("children", ProductArray);
	
		return jsonObject;

	}

}
