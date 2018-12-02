package com.nam.content.message.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nam.content.message.constant.MessageTypeEnum;
import com.nam.content.message.validator.ContentTypeProcessor;
import com.nam.content.message.validator.impl.ContentTypeValidatorImpl;

public class MessageCapture {
	//Logger log = Logger.getLogger(MessageHandler.class);
	public List<String> readMessages() {
		List<String> messageList = new ArrayList<String>();
		Path path = Paths.get("C://tmp//message.txt");
		try (BufferedReader reader = Files.newBufferedReader(path,
				Charset.forName("UTF-8"))) {
			String currentLine = null;
			while ((currentLine = reader.readLine()) != null) {
				messageList.add(currentLine);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return messageList;
	}
	
	public void handleCategory(List<String> messageContent){
		Map<String,String> typeCategoryMap = new HashMap<String,String>();
		for(String message:messageContent){
			ContentTypeProcessor contentTypeValidator = new ContentTypeValidatorImpl();
			MessageTypeEnum messageType = contentTypeValidator.getMessageType(message);
			MessageFactory messageFactory = new MessageFactory();
			MessageHandler messageHandler = messageFactory.getMessageHandler(messageType); 
			messageHandler.processMessage(message);
			
		
		}
	}

	public static void main(String[] args) {
		MessageCapture mh = new MessageCapture();		
		List<String> messages = mh.readMessages();
		mh.handleCategory(messages);
	}

}
