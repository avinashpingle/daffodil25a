package com.skillio.base;

import org.openqa.selenium.remote.RemoteWebDriver;
/**
 * Manages a thread-local instance of {@link RemoteWebDriver} for parallel test execution.
 *
 * <p>This utility provides a single place to set, get and remove a {@code RemoteWebDriver}
 * instance that is scoped to the current thread using a {@link ThreadLocal} variable.
 * Tests or test fixtures should call {@link #setDriver(RemoteWebDriver)} to store the driver
 * for the current thread and {@link #unload()} to remove it when finished to avoid memory leaks.
 *
 * <p>The class is non-instantiable and exposes only static accessors for thread-safe driver
 * management.
 */
public class DriverManager {

	private DriverManager() {
		
	}
	
	static ThreadLocal<RemoteWebDriver> thread = new ThreadLocal<RemoteWebDriver>();
	
	public static RemoteWebDriver getDriver() {
		return thread.get();
	}
	
	public static void setDriver(RemoteWebDriver driver) {
		thread.set(driver);
	}
	
	public static void unload() {
		thread.remove();
	}
}