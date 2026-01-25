package com.skillio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.skillio.base.DriverManager;

public class LoginPage {

	@FindBy(xpath="//input[@name=\"username\"]")
	WebElement username; //null
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement loginBtn;
	
	
	public LoginPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public void enterUsername(String usernm) {
		username.sendKeys(usernm);
		System.out.println("Entered username");
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
		System.out.println("Entered password");
	}

	public void clickOnLoginBtn() {
		loginBtn.click();
		System.out.println("Clicked on login button");
	}
	
}
