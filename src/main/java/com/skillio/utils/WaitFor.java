package com.skillio.utils;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.skillio.base.DriverManager;
import com.skillio.base.Keyword;

public class WaitFor {

	private static WebDriverWait wait;
	static{
		wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(35));
		wait.pollingEvery(Duration.ofMillis(250));
		wait.ignoring(NoSuchElementException.class);
	}
	
	public static void presenceOfElement(By element) {
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}
	
	/**
	 * This method will wait for specified element for {@code 35 seconds}. 
	 * If element is not present during max time out, then this method will throw TimeOutException
	 * @param locator
	 */
	public static void presenceOfElement(String locator) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		Keyword keyword = new Keyword();
		By by = keyword.getBy(locatorType, locatorValue);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		
	}
	
}
