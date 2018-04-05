package com.schneider.solr.model;

import java.sql.Timestamp;

public class QuestionAnswer {
	
	private String searchId = null;
	private String question =null; 
	private String answer = null; 
	private Timestamp searchDate =null;   
	private String documentId =null;  
	private String answerType = null;
	public String getSearchId() {
		return searchId;
	}
	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Timestamp getSearchDate() {
		return searchDate;
	}
	public void setSearchDate(Timestamp searchDate) {
		this.searchDate = searchDate;
	}
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getAnswerType() {
		return answerType;
	}
	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}
 
	@Override
	public String toString() {
		String quesAnsStr ="Solr_questn_ans_main<;>"+getSearchId()+"<;>"+getQuestion()+"<;>"+getAnswer()+"<;>"+getSearchDate()+"<;>"+getDocumentId()+"<;>"+getAnswerType();
		return quesAnsStr;
	}

}
