package com.info.service;

import org.springframework.stereotype.Service;

import com.info.model.Message;

@Service
public class MessageService {

	private Message message;

	public Message getMessage() {
		return message;
	}

	
	public void setMessage(Message mes) {
		this.message = mes;
	}

}
