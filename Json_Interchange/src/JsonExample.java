import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JsonExample {

	public static void main(String[] args) throws JSONException, IOException {

		JSONArray jsonArray = new JSONArray(
				readJsonFile("C:\\Users/deevanshu.mahajan/Desktop/search.json"));

		List<JsonMap> list= new ArrayList<JsonMap>();
		String str = "";
		Gson gson= new Gson();
		JsonMap map;
		for (int i = 0; i < jsonArray.length(); i++) {
			map=gson.fromJson(jsonArray.get(i).toString(), JsonMap.class);
			list.add(map);
		}
		
		System.out.println(list);

		
		
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
