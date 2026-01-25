package com.skillio.utils;


public class OR {

	private static final String path = "/src/main/resources/OR.properties";
	
	public static String locator(String key) {
		String baseDir = System.getProperty("user.dir");
		String locator=null;
		PropHandler prop = new PropHandler(baseDir+path);
		locator = prop.get(key, baseDir+path);
		
		return locator;
	}
}
