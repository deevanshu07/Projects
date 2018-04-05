package com.info.jsonParsing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

public class MyProject1 {

	public static void main(String[] args) {

		// JSONParser parser = new JSONParser();
		//
		// try {
		// Object obj = parser.parse(new FileReader(
		// "C:\\Users/deevanshu.mahajan/Desktop/JSONS/solr.json"));
		// JSONObject jsonObject = (JSONObject) obj;
		// JSONObject jsonChildObject = (JSONObject)jsonObject.get("response");
		// System.out.println(jsonChildObject);
		// JSONObject level= new
		// JSONObject(jsonChildObject.get("docs").toJSONString());
		// System.out.println(level);
		//
		//
		//
		//
		//
		// } catch (Exception e) {
		//
		// }
		JSONObject jsonObject = new JSONObject(
				readJsonFile("C:\\Users/deevanshu.mahajan/Desktop/JSONS/solr1.json"));

		JSONObject response = jsonObject.getJSONObject("response");
		JSONArray docs = response.getJSONArray("docs");
		// System.out.println(docs);

		// For changing Body tag
		for (int i = 0; i < docs.length(); i++) {
			JSONObject js = docs.getJSONObject(i);

			/*JSONArray content = js.getJSONArray("content");
			String summary = js.getString("summary");*/

			System.out.println(js);
			JSONObject jsom = new JSONObject();
			
			
			jsom.put("summary", js.get("summary"));
			jsom.put("content", js.get("content"));
			js.put("body", jsom);
			

			js.remove("content");
			js.remove("summary");
			/*
			 * Iterator<String> keys=js.keys();
			 * 
			 * while (keys.hasNext()) { String key =keys.next();
			 * //System.out.println("Key="+key+"\n");
			 * 
			 * }
			 */
			
		}
		

		// For changing highlightning tag
		/*
		 * JSONObject highlighting = jsonObject.getJSONObject("highlighting");
		 * JSONArray array1= new JSONArray(); array1.put(highlighting);
		 * 
		 * 
		 * for(Iterator iter = highlighting.keySet().iterator();iter.hasNext();)
		 * { String key = (String) iter.next(); JSONObject highLigtedObject= new
		 * JSONObject(); String str[]={"content", "title"}; JSONObject obj= new
		 * JSONObject(); JSONArray contenArray= new JSONArray(); JSONArray
		 * titleArray= new JSONArray(); obj.put(str[0], contenArray);
		 * obj.put(str[1], titleArray);
		 * 
		 * 
		 * highlighting.put(key, obj); //System.out.println(highlighting); }
		 */

		JSONObject facet_counts = jsonObject.getJSONObject("facet_counts");
		JSONObject facet_fields = facet_counts.getJSONObject("facet_fields");

		JSONArray finalArray = new JSONArray();
		JSONObject obj;
		for (Iterator iter = facet_fields.keySet().iterator(); iter.hasNext();) {
			obj = new JSONObject();
			String key = (String) iter.next();

			int childLength = facet_fields.getJSONArray(key).length();

			JSONArray valueArray = facet_fields.getJSONArray(key);
			// System.out.println(valueArray);

			// System.out.println(a);
			/* System.out.println(valueArray.getJSONObject(2)); */

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
			// System.out.println(finalArray);

			/*
			 * System.out.println(key);
			 * System.out.println(facet_fields.get(key));
			 */
			// if () {
			// System.out.println("DDDds");
			// }

		}

		
		facet_counts.put("facet_fields", finalArray);

		
		
		
	}

	public static String readJsonFile(String filePath) {
		String jsonString = "";

		try (BufferedReader br = new BufferedReader(new FileReader(filePath));) {
			// Check if following code is good way of reading json file.
			// URI uri = new URI(filePath);
			// JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
			// JSONObject root = new JSONObject(tokener);

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
