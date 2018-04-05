package com.schneider.solr.model;

public class FacetModel{
	
	public String facetName;
	public int position;
	public long facetCount;
	
	public String getFacetName() {
		return facetName;
	}

	public void setFacetName(String facetName) {
		this.facetName = facetName;
	}
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public long getFacetCount() {
		return facetCount;
	}

	public void setFacetCount(long facetCount) {
		this.facetCount = facetCount;
	}
}

