package com.nam.content.message.validator;

import com.nam.content.message.constant.MessageTypeEnum;

public interface ContentTypeProcessor {
	public MessageTypeEnum getMessageType(String content);
	

}
