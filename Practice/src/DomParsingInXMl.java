import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;


class ASAA{
	
	static void method(){
		System.out.println("ABC");
	}
}

class BDDDD extends ASAA{
	static void method(){
		System.out.println("BCD");
	}
}
public class DomParsingInXMl {
	public static void main(String[] args) throws Exception {

		ASAA obj= new BDDDD();
		obj.method();
		String fileName = "C:\\Users\\deevanshu.mahajan\\Desktop\\data.xml";
		File file = new File(fileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fileName);
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("folder");
		for (int i = 0; i < nList.getLength(); i++) {
			Node node = nList.item(i);
			Element element = (Element) node;
			String element1 = element.getAttribute("name");
			if (element1.startsWith("u")) {
				System.out.println(element1);
			}
		}

	}
}
