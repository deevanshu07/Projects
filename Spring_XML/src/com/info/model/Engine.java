package com.info.model;

public class Engine {
	private String modelNumber;

	public  Engine() {
		System.out.println("Engine class loaded");
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;

	}

	public String getModelNumber() {
		return modelNumber;
	}

	@Override
	public String toString() {
		return "Engine [modelNumber=" + modelNumber + "]";
	}
}
