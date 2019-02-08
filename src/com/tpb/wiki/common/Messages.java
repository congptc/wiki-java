package com.tpb.wiki.common;


public class Messages {
	
	private String messageType;
	
	private String content;
	
	

	public Messages(String messageType, String content) {
		super();
		this.messageType = messageType;
		this.content = content;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
