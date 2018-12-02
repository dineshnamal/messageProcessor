package com.nam.content.message.validator.impl;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.nam.content.message.constant.MessageTypeEnum;
import com.nam.content.message.validator.ContentTypeProcessor;

public class ContentTypeValidatorImpl implements ContentTypeProcessor {


	public boolean isValidXml(String xmlContent) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			return false;
		}
		db.setErrorHandler(new XmlErrorHandler());
		try {
			db.parse(new InputSource(new StringReader(xmlContent)));
		} catch (SAXException | IOException e) {
			return false;
		}
		return true;
	}

	public boolean isValidJson(String jsonContent) {
		try {
			Gson gson = new GsonBuilder().create();
			gson.toJson(jsonContent);
		} catch (JsonIOException ex) {
			return false;
		}

		return true;

	}

	
	public boolean isValidCSV(String csvContent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MessageTypeEnum getMessageType(String content) {
		if(isValidXml(content)){
			return MessageTypeEnum.XML;
		}else if(isValidJson(content)){
			return MessageTypeEnum.JSON;
		}else if(isValidCSV(content)){
			return MessageTypeEnum.CSV;
		}
		return null;
	}

}
