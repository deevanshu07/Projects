package com.info.model.innerBean;

public class Car {
	private String carName;
	 Engine engine;
	public String getCarName() {
		return carName;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public void carDetails(){
		System.out.println("Car Name="+carName+"\n"+"Model Number="+engine.getModelNumber());
	}
	
	@Override
	public String toString() {
		return "Car [carName=" + carName + ", engine=" + engine + "]";
	}

}
