package com.skillio.base;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.skillio.constants.OfEnv;
import com.skillio.pages.LoginPage;
import com.skillio.repo.Locator;
import com.skillio.utils.App;
import com.skillio.utils.WaitFor;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	Keyword keyword = new Keyword();

	@Before
	public void setUp() throws Exception {
		keyword.openBrowser(App.getBrowserName());

		
		String env = System.getProperty("env");
		
		LoginPage login = new LoginPage();
		if (env.equalsIgnoreCase("qa")) {
			DriverManager.getDriver().get(App.getAppUrl(OfEnv.QA));
			WaitFor.presenceOfElement(Locator.userName);
			
			login.enterUsername(App.getUserName(OfEnv.QA));
			login.enterPassword(App.getPassword(OfEnv.QA));
			
		}else if(env.equalsIgnoreCase("dev")) {
			DriverManager.getDriver().get(App.getAppUrl(OfEnv.DEV));
			login.enterUsername(App.getUserName(OfEnv.DEV));
			login.enterPassword(App.getPassword(OfEnv.DEV));
			WaitFor.presenceOfElement(Locator.userName);
		}else if(env.equalsIgnoreCase("stage")) {
			DriverManager.getDriver().get(App.getAppUrl(OfEnv.STAGE));
			WaitFor.presenceOfElement(Locator.userName);
			login.enterUsername(App.getUserName(OfEnv.STAGE));
			login.enterPassword(App.getPassword(OfEnv.STAGE));
		}else {
			
		}

		login.clickOnLoginBtn();

	}

	@After
	public void tearDown() {
		DriverManager.getDriver().quit();
	}
}
