package com.info.model;

import org.springframework.beans.factory.annotation.Autowired;

public class DependencyA {

	private DependencyB B;

	
	@Autowired
	public DependencyA(DependencyB B) {
		this.B = B;
	}
}
