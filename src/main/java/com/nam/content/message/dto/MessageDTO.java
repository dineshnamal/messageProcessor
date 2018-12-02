package com.nam.content.message.dto;

import com.nam.content.message.constant.MessageTypeEnum;

public class MessageDTO {
	private Integer messageId;
	private MessageTypeEnum messageType;
	private String content;

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public MessageTypeEnum getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageTypeEnum messageType) {
		this.messageType = messageType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
