package com.info.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

interface Image {
	public void displayImage();
}

class RealImage implements Image {

	private String fileName = null;

	public RealImage(final String fileName) {
		this.fileName = fileName;
		loadFromDisk();
	}

	private void loadFromDisk() {
		System.out.println("loading...." + fileName);
	}

	@Override
	public void displayImage() {
		// TODO Auto-generated method stub
		System.out.println("Displaying " + fileName);
	}

}

class ProxyImage implements Image {

	private RealImage image = null;
	private String fileName = null;

	public ProxyImage(final String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void displayImage() {
		// TODO Auto-generated method stub
		if (image == null) {
			image = new RealImage(fileName);
		} else {
			image.displayImage();
		}

	}

}

interface Vehicle {
	void noOfTyres();
}

class Car implements Vehicle {

	@Override
	public void noOfTyres() {
		// TODO Auto-generated method stub
		System.out.println("Car has four tyres");
	}

}

class Bike implements Vehicle {

	@Override
	public void noOfTyres() {
		// TODO Auto-generated method stub
		System.out.println("Bike has two tyres");
	}

}

@Configuration
class AppConfiguration {

	@Bean(name="bike")
	public Vehicle getBike() {
		return new Bike();
	}

	@Bean(name="car")
	public Vehicle getCar() {
		return new Car();
	}
}

interface servlet{
	void init();
	public abstract void service();
	void destroy();
}

abstract class generic implements servlet{
	public abstract void service();
	public void init(){
		
	}
	public void destroy(){
		
	}
}


class myservlet extends generic{


	@Override
	public void service() {
		// TODO Auto-generated method stub
		
	}

	
	
}
public class MainClass {
	public static void main(String[] args) {
		/*
		 * final Image image1 = new ProxyImage("HiRes_10MB_Photo1"); final Image
		 * image2 = new ProxyImage("HiRes_10MB_Photo2"); image1.displayImage();
		 * // loading necessary image1.displayImage(); // loading necessary
		 */
		/*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfiguration.class);
		Vehicle typeOfVehicle =  context.getBean("car",Vehicle.class);
		typeOfVehicle.noOfTyres();*/
		
		
		Collection<String> collection= new ArrayList<String>();

	}

}
