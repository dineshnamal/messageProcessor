package com.nam.content.message.validator.impl;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XmlErrorHandler implements ErrorHandler {

	@Override
	public void warning(SAXParseException exception) throws SAXException {
		System.out.println(exception.getMessage());

	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		System.out.println(exception.getMessage());

	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		System.out.println(exception.getMessage());

	}

}
