import java.util.HashMap;
import java.util.Map;

public class SortingMap {
	public static void main(String[] args) {

		Map<String, String> treemap = new HashMap<String, String>();
		treemap.put("data", "Mozilla Firefox");
		treemap.put("outages.1.product", "Google Chrome");
		treemap.put("outages.2.product", "Internet Explorer");
		treemap.put("outages.1.description", "Moderate Internet Outage ");
		
		treemap.put("outages.1.severity", "Moderate");
		System.out.println(treemap.get("data"));
		StringBuilder sb= new StringBuilder();
		String s=treemap.get("data");
		sb=sb.append(s).append("\t\n\n").append("Data");
		treemap.put("data",sb.toString());
		System.out.println(treemap.get("data"));
		
	}

}
