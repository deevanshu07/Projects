package com.infy.model;

import java.util.List;

public class Post 
{
	private int postId;
	private String postName;
	List <Reply> reply1;
	
	public Post()
	{
		
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public List<Reply> getReply1() {
		return reply1;
	}

	public void setReply1(List<Reply> reply1) {
		this.reply1 = reply1;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postName=" + postName
				+ ", reply1=" + reply1 + "]";
	}

	public Post(/*int postId,*/ String postName, List<Reply> reply1) {
		super();
		/*this.postId = postId;*/
		this.postName = postName;
		this.reply1 = reply1;
	}

}