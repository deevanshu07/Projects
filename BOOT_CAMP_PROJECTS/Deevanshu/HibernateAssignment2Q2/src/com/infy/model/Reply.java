package com.infy.model;

public class Reply
{

	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", replyname=" + replyname
				+ ", SendBy=" + SendBy + "]";
	}
	private int replyId;
	String replyname;
	String SendBy;
	
	public Reply()
	{
		
	}
	public Reply( String replyname, String sendBy) 
	{
		super();
		
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
