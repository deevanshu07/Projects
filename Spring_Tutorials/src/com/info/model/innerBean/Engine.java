package com.info.model.innerBean;

public class Engine {
	private String modelNumber;

	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	@Override
	public String toString() {
		return "Engine [modelNumber=" + modelNumber + "]";
	}
}
