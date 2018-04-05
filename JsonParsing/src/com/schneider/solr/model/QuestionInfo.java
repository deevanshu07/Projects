package com.schneider.solr.model;

import java.sql.Timestamp;

public class QuestionInfo {
	
	private String question =null;
	private int qCTRATE = 0;
	private Timestamp searchDate = null;
	private String answerFlag = null;
	private String locale = null;
	private String SAMAccountName = null;
	private String wwTechSupportId = null;
	private String sessionId = null;
	private String searchId = null;
	private String userGroup = null;
	private String facetFlag = null;
	private String barndAndEntitlements = null;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getqCTRATE() {
		return qCTRATE;
	}
	public void setqCTRATE(int qCTRATE) {
		this.qCTRATE = qCTRATE;
	}
	public Timestamp getSearchDate() {
		return searchDate;
	}
	public void setSearchDate(Timestamp searchDate) {
		this.searchDate = searchDate;
	}
	public String getAnswerFlag() {
		return answerFlag;
	}
	public void setAnswerFlag(String answerFlag) {
		this.answerFlag = answerFlag;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getSAMAccountName() {
		return SAMAccountName;
	}
	public void setSAMAccountName(String sAMAccountName) {
		SAMAccountName = sAMAccountName;
	}
	public String getWwTechSupportId() {
		return wwTechSupportId;
	}
	public void setWwTechSupportId(String wwTechSupportId) {
		this.wwTechSupportId = wwTechSupportId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getSearchId() {
		return searchId;
	}
	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}
	public String getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	public String getFacetFlag() {
		return facetFlag;
	}
	public void setFacetFlag(String facetFlag) {
		this.facetFlag = facetFlag;
	}
	
	public String getBarndAndEntitlements() {
		return barndAndEntitlements;
	}
	public void setBarndAndEntitlements(String barndAndEntitlements) {
		this.barndAndEntitlements = barndAndEntitlements;
	}
	@Override
	public String toString() {
		String quesInfoStr="Solr_questioninfo<;>"+getSAMAccountName()+"<;>"+getWwTechSupportId()+"<;>"+getQuestion()+"<;>"+getSearchDate()+"<;>"+getSearchId()+"<;>"+getLocale()+"<;>"+getqCTRATE()+"<;>"+getAnswerFlag()+"<;>"+getSessionId()+"<;>"+getFacetFlag()+"<;>"+getBarndAndEntitlements();
		return quesInfoStr;
	}

}
