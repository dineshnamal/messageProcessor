package com.nam.content.message.handler;

import com.nam.content.message.constant.MessageTypeEnum;

public class MessageFactory {
	public MessageHandler getMessageHandler(MessageTypeEnum messageType ){
		if(MessageTypeEnum.JSON.name().equals(messageType)){
			return new JSONMessageHandler();
		}else if (MessageTypeEnum.CSV.name().equals(messageType)) {
			return new CSVMessageHandler();
		} else if (MessageTypeEnum.XML.name().equals(messageType)) {
			return new XmlMessageHandler();
		}
		return null;
	}
}
