package com.info.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Car implements ApplicationContextAware {

	private Engine engine;
	private ApplicationContext context;

	private String carName;
	public Car() {
		System.out.println("Car class loaded");
	}

	public String getCarName() {
		return carName;
	}

	public Engine getEngine() {
		return engine;
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		// TODO Auto-generated method stub
		this.context = context;

	}

/*	public Engine getEngine() {
		return context.getBean(Engine.class);
	}
*/

	public void setCarName(String carName) {
		this.carName = carName;
	}

	
	@Autowired
	@Qualifier("engine")
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Car [engine=" + engine + ", carName=" + carName + "]";
	}

}
