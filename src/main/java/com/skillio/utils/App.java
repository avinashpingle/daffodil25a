package com.skillio.utils;

public class App {
	private static PropHandler prop = new PropHandler("/src/main/resources/application.properties");

	private App() {
		// TODO Auto-generated constructor stub
	}

	public static String getBrowserName() {

		String browserName = prop.get("browser_name");
		return browserName;
	}

	public static String getAppUrl(String env) {

		return prop.get(env + "_app_url"); // qa

	}

	public static String getUserName(String env) {
		return prop.get(env + "_username"); // qa
	}

	public static String getPassword(String env) {
		return prop.get(env + "_password"); // qa
	}
}
