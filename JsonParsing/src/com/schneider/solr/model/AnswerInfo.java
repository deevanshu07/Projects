package com.schneider.solr.model;

import java.sql.Timestamp;

public class AnswerInfo {
	
	private String answerType = null;
	private String answer = null;
	private int answerCTPosition = 0;
	private int answerCTRATE = 0;
	private Timestamp searchDate = null;
	private String documentId = null;
	private String locale = null;
	private String searchId = null;
	public String getAnswerType() {
		return answerType;
	}
	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getAnswerCTPosition() {
		return answerCTPosition;
	}
	public void setAnswerCTPosition(int answerCTPosition) {
		this.answerCTPosition = answerCTPosition;
	}
	public int getAnswerCTRATE() {
		return answerCTRATE;
	}
	public void setAnswerCTRATE(int answerCTRATE) {
		this.answerCTRATE = answerCTRATE;
	}
	
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getSearchId() {
		return searchId;
	}
	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}
	public Timestamp getSearchDate() {
		return searchDate;
	}
	public void setSearchDate(Timestamp searchDate) {
		this.searchDate = searchDate;
	}
	
	@Override
	public String toString() {
		String ansInfo="Solr_answerinfo<;>"+getAnswerType()+"<;>"+getAnswer()+"<;>"+getAnswerCTPosition()+"<;>"+getAnswerCTRATE()+"<;>"+getSearchDate()+"<;>"+getDocumentId()+"<;>"+getLocale()+"<;>"+getSearchId();
		return ansInfo;
	}
}
