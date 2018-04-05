package com.info.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		/*
		 * String sJava =
		 * "\\u007B\\u0021\\u0074\\u0061\\u0067\\u003D\\u004C\\u0061\\u006E\\u0067\\u0075\\u0061\\u0067\\u0065\\u0073\\u007D\\u004C\\u0061\\u006E\\u0067\\u0075\\u0061\\u0067\\u0065\\u0073\\u003A\\u0028\\u0022\\u0A2A\\u0A70\\u0A1C\\u0A3E\\u0A2C\\u0A40\\u0022\\u0029\\u0020"
		 * ;
		 */
		
		String sJava=
				"\\u007B\\u0021\\u0074\\u0061\\u0067\\u003D\\u004C\\u0061\\u006E\\u0067\\u0075\\u0061\\u0067\\u0065\\u0073\\u007D\\u004C\\u0061\\u006E\\u0067\\u0075\\u0061\\u0067\\u0065\\u0073\\u003A\\u0028\\u0022\\u0939\\u093F\\u0928\\u094D\\u0926\\u0940\\u0022\\u0029\\u0020";
		
	
		/*
		 * Resource resource = new ClassPathResource("applicationContext.xml");
		 * 
		 * @SuppressWarnings("unused") BeanFactory factory = new
		 * XmlBeanFactory(resource); Spring_Map q= (Spring_Map)
		 * factory.getBean("springMapBean"); Setter_Inject q= (Setter_Inject)
		 * factory.getBean("sett	erBean"); A a= (A) factory.getBean("a");
		 * a.display(); ApplicationContext context=new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); A
		 * a1=context.getBean("a",A.class); a1.display();
		 * 
		 * ApplicationContext context=new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); A
		 * a=context.getBean("a",A.class); a.msg();
		 * 
		 * ApplicationContext context=new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); Printable
		 * p=(Printable)context.getBean("p"); p.print();
		 * 
		 * String input="{!tag=Languages}Languages:('español')";
		 * System.out.println(Cdata); String data=URLEncoder.encode(Cdata,
		 * "UTF-8"); System.out.println(data);
		 * 
		 * String data1=URLDecoder.decode(data,"ISO-8859-1");
		 * System.out.println(data1); String correctDecoded =
		 * URLDecoder.decode(data1, "UTF-8");
		 * System.out.println(correctDecoded);
		 * 
		 * 
		 * System.out.println("Original input string from client: " + input);
		 * String myString = null;
		 * 
		 * String encoded = URLEncoder.encode(input, "ISO-8859-1");
		 * System.out.println("URL-encoded by client with UTF-8: " + encoded);
		 * 
		 * String incorrectDecoded = URLDecoder.decode(encoded, "ISO-8859-1");
		 * System.out.println("Then URL-decoded by server with ISO-8859-1: " +
		 * incorrectDecoded);
		 * 
		 * String correctDecoded = URLDecoder.decode(incorrectDecoded, "UTF-8");
		 * System.out.println("Server should URL-decode with UTF-8: " +
		 * correctDecoded); correctDecoded = URLEncoder.encode(correctDecoded,
		 * "UTF-8").replaceAll("\\+", " "); System.out.println(correctDecoded);
		 * try {
		 * 
		 * byte[] utf8Bytes = sJava.getBytes("UTF8"); String text = new
		 * String(utf8Bytes,"UTF8"); System.out.println(text);
		 * 
		 * } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
		 */
		/*
		 * String str = sJava.split(" ")[0]; str = str.replace("\\","");
		 * String[] arr = str.split("u"); String text = ""; for(int i = 1; i <
		 * arr.length; i++){ int hexVal = Integer.parseInt(arr[i], 16); text +=
		 * (char)hexVal; } System.out.println(text);
		 */
		
/*
		String out = StringEscapeUtils.unescapeJava(sJava);
		System.out.println(out);
		System.out.println(decode(sJava));
		
		
		byte[] bytes = sJava.getBytes();

		String str = new String(bytes, Charset.forName("UTF-8"));

		System.out.println(str);
	}

	static final String decode(final String in) {
		String working = in;
		int index;
		index = working.indexOf("\\u");
		while (index > -1) {
			int length = working.length();
			if (index > (length - 6))
				break;
			int numStart = index + 2;
			int numFinish = numStart + 4;
			String substring = working.substring(numStart, numFinish);
			int number = Integer.parseInt(substring, 16);
			String stringStart = working.substring(0, index);
			String stringEnd = working.substring(numFinish);
			working = stringStart + ((char) number) + stringEnd;
			index = working.indexOf("\\u");
		}
		return working;
	}*/
		
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	    //EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");  
/*	    int status=dao.saveEmployee1(new Employee("Amit",102,35000));  
	    System.out.println(status);  
	    */
/*	    List<Employee> list= dao.getAllEmployees1();
	    System.out.println(list);
	    
	    int status= dao.updateEmployee(new Employee("Deevanshu", 101, 1111));
	    System.out.println(status);
	    
	    List<Employee> list1= dao.getAllEmployees1();
	    System.out.println(list1);*/
		EmployeehDao dao=(EmployeehDao)ctx.getBean("d");  
		 Employee e=new Employee();  
		    e.setId(114);  
		    e.setName("varun");  
		    e.setSalary(50000);  
		    dao.saveEmployee(e);
		    
		    System.out.println(dao.getEmployees());
	    
	    
	   /* Boolean b=dao.saveEmployeeByPreparedStament1(new Employee("Deevanshu", 1019,50));
	    System.out.println(b);*/
	}
}
