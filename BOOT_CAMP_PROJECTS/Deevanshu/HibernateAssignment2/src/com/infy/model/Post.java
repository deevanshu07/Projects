package com.infy.model;

public class Post 
{
	private int postId;
	private String postName;
	Reply reply;
	
	public Post()
	{
		
	}
	public Post(int postId, String postName, Reply reply) 
	{
		super();
		this.postId = postId;
		this.postName = postName;
		this.reply = reply;
	}
	
	@Override
	public String toString() 
	{
		return "Post [postId=" + postId + ", " +
				"postName=" + postName + ", reply="
				+ reply + "]";
	}
	
	public int getPostId() 
	{
		return postId;
	}
	
	public void setPostId(int postId) 
	{
		this.postId = postId;
	}
	
	public String getPostName() 
	{
		return postName;
	}
	
	public void setPostName(String postName)
	{
		this.postName = postName;
	}
	
	public Reply getReply() 
	{
		return reply;
	}
	
	public void setReply(Reply reply) 
	{
		this.reply = reply;
	}
	
	

}
