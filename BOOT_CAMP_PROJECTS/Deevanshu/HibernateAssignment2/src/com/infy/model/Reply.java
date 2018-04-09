package com.infy.model;

public class Reply
{

	private int replyId;
	String replyname;
	String SendBy;
	
	public Reply()
	{
		
	}
	public Reply(int replyId, String replyname, String sendBy) 
	{
		super();
		this.replyId = replyId;
		this.replyname = replyname;
		SendBy = sendBy;
	}
	

	public int getReplyId() 
	{
		return replyId;
	}
	
	public void setReplyId(int replyId)
	{
		this.replyId = replyId;
	}
	public String getReplyname() 
	{
		return replyname;
	}
	public void setReplyname(String replyname) 
	{
		this.replyname = replyname;
	}
	public String getSendBy() 
	{
		return SendBy;
	}
	public void setSendBy(String sendBy) 
	{
		SendBy = sendBy;
	}
	

}
