package com.nam.content.message.reader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class ContentReader {
	
	
	public void processFile(File file) throws Exception{
	FileInputStream inputStream = null;
	Scanner sc = null;
	try {
	    inputStream = new FileInputStream(file);
	    sc = new Scanner(inputStream, "UTF-8");
	    while (sc.hasNextLine()) {
	        String line = sc.nextLine();
	        // System.out.println(line);
	    }
	    // note that Scanner suppresses exceptions
	    if (sc.ioException() != null) {
	        throw sc.ioException();
	    }
	} finally {
	    if (inputStream != null) {
	        inputStream.close();
	    }
	    if (sc != null) {
	        sc.close();
	    }
	}
	}
}
