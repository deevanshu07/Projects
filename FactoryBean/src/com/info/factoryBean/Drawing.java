package com.info.factoryBean;


class Multi implements Runnable{

	@Override
	public void run() {
		System.out.println("Deevanshu");
		
	}
	
}

public class Drawing {

	// BeanFactory factory= new XmlBeanFactory(new
	// FileSystemResource("spring.xml"));
	/*
	 * ApplicationContext context= new
	 * ClassPathXmlApplicationContext("spring.xml"); Triangle tri= (Triangle)
	 * context.getBean("triangle"); tri.drawtraingle();
	 */

	static void validate(int age){
		
		try{
			System.out.println(10/0);
			throw new ArithmeticException();
		}
		
		catch(ArithmeticException e){
			System.out.println("Exception thrown");
			System.out.println(e.getMessage());	
		}
			
		System.out.println("Errror");
	}

	public static void main(String args[]) throws Exception {
		validate(13);
		System.out.println("rest of the code...");
		
		Multi m= new Multi();
		m.run();
		
	}

}
