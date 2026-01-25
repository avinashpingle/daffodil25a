package com.skillio.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropHandler {

	String filePath;
	
	public PropHandler(String filePath) {
		this.filePath = filePath;
	}

	public String get(String key, String filePath)  {
		FileInputStream fis = null;
		String value = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		value = prop.getProperty(key);
		
		return value;
	}
	
	
	public String get(String key) {
		String baseDir = System.getProperty("user.dir");
		return get(key, baseDir+filePath);
		
	}
}
