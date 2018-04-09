package com.infogain.controller;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	
	private String userName;
	
	private String password;
	
	private String gender;
	
	private String about;
	
	private String country;
	
	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	private String toDate;
	private String fromDate;
	private ArrayList<String> countryList;
	
	private String[] technology;
	
	private ArrayList<String> technologyList;
	
	private Boolean  newsLetter;

	public String populate() {

		countryList = new ArrayList<String>();
		countryList.add("Hindustan");
		countryList.add("Iraq");
		countryList.add("Nigeria");
		
		technologyList = new ArrayList<String>();
		technologyList.add("Struts2");
		technologyList.add("Hibernate");
		technologyList.add("Spring");
		
		technology = new String[]{"Struts2","Hibernate"};
		newsLetter = true;		
		return "populate";
	}

	public String execute() {
		return SUCCESS;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public ArrayList<String> getCountryList() {
		return countryList;
	}

	public void setCountryList(ArrayList<String> countryList) {
		System.out.println("setCountryList");
		this.countryList = countryList;
	}

	public String[] getTechnology() {
		return technology;
	}

	

	public ArrayList<String> getTechnologyList() {
		return technologyList;
	}

	public void setTechnologyList(ArrayList<String> technologyList) {
		this.technologyList = technologyList;
	}

	public Boolean getNewsLetter() {
		return newsLetter;
	}

	public void setTechnology(String[] technology) {
		this.technology = technology;
	}

	public void setNewsLetter(Boolean newsLetter) {
		this.newsLetter = newsLetter;
	}

	


}
