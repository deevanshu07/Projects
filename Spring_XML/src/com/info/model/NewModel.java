package com.info.model;

abstract class IndentificationNumber{
	protected String identificationNumber;
	abstract String getIdentificationNumber();
}

class Passport extends IndentificationNumber{

	@Override
	String getIdentificationNumber() {
		// TODO Auto-generated method stub
		return "Passport";
	}
	
}


class ID_Card extends IndentificationNumber{

	@Override
	String getIdentificationNumber() {
		// TODO Auto-generated method stub
		return "ID_Card";
	}

}


class DrivingLicense extends IndentificationNumber{

	@Override
	String getIdentificationNumber() {
		// TODO Auto-generated method stub
		return "Driving License";
	}
	
}


abstract class Account{
	protected String typeOfAccount;
	abstract void accountType();
}

abstract class Client{
	protected String client;
	abstract void typeOfClient();
	
}

class Individual extends Client{

	@Override
	void typeOfClient() {
		// TODO Auto-generated method stub
		client= "Individual";
	}
	
}

class Institutions extends Client{

	@Override
	void typeOfClient() {
		// TODO Auto-generated method stub
		client= "Institutions";
	}
	
}

class Companies extends Client{

	@Override
	void typeOfClient() {
		// TODO Auto-generated method stub
		client= "Companies";
	}
	
}

public class NewModel {
	

}
