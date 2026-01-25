package com.skillio.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.skillio.exceptions.InvalidBrowserError;
import com.skillio.exceptions.InvalidLocatorError;

public class Keyword {

	private static RemoteWebDriver driver;

	// First keyword
	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else {
			throw new InvalidBrowserError(browserName);
		}
		
		DriverManager.setDriver(driver);
	}

	public void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public void enterText(String locator, String textToEnter) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		enterText(locatorType, locatorValue,textToEnter);
	}
	
	public By getBy(String locatorType, String locatorValue) {
		By element = null;
		if (locatorType.equalsIgnoreCase("id")) {
			element = By.id(locatorValue);
		} else if (locatorType.equalsIgnoreCase("name")) {
			element = By.name(locatorValue);
		} else if (locatorType.equalsIgnoreCase("classname")) {
			element = By.className(locatorValue);
		} else if (locatorType.equalsIgnoreCase("tagname")) {
			element = By.tagName(locatorValue);
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			element = By.linkText(locatorValue);
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			element = By.partialLinkText(locatorValue);
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			element = By.xpath(locatorValue);
		} else if (locatorType.equalsIgnoreCase("css")) {
			element = By.cssSelector(locatorValue);
		} else {
			throw new InvalidLocatorError(locatorType);
		}
		return element;
	}
	public WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;
		driver.findElement(getBy(locatorType, locatorValue));
		
		return element;
	}

	public void clickOn(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}
	
	public void clickOn(String locator) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		clickOn(locatorType,locatorValue);
	}

	public String getText(String locatorType, String locatorValue) {
		return getWebElement(locatorType, locatorValue).getText();
	}

	public String getText(String locator) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		return getText(locatorType, locatorValue);
	}

	public void launchUrl(String appUrl) {
		driver.get(appUrl);
	}
}