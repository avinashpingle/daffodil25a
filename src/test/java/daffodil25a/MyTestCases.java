package daffodil25a;

import static com.skillio.utils.OR.locator;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.skillio.base.Keyword;
import com.skillio.base.TestBase;
import com.skillio.pages.Dashboard;
import com.skillio.repo.Locator;

public class MyTestCases {

	WebDriverWait waitFor;
	Keyword keyword = new Keyword();

	@Test
	public void verifyEmployeeNameAppearsWhileCreatingAnUser() throws InterruptedException, IOException {
		Thread.sleep(3000);
		keyword.clickOn(Locator.viewPIMMenu);
		keyword.clickOn(locator("addBtn"));
		keyword.enterText(Locator.firstName, "Rushi");
		keyword.enterText(Locator.lastName, "Kapoor");
		keyword.clickOn(Locator.saveBtn);
		keyword.clickOn(Locator.adminMenu);
		keyword.clickOn(Locator.adminAddBtn);
		keyword.enterText(Locator.typeForHints, "Rushi");
		String empName = keyword.getText(Locator.adminTypeOption);
		Assert.assertEquals("Rushi Kapoor", empName);

	}

	@Test
	public void verifyEmployeeNameAppearsWhileCreatingAnUserUsingPom() throws InterruptedException, IOException {
		Thread.sleep(3000);
		Dashboard dashboard = new Dashboard();
		dashboard.openPIMMenu();
		dashboard.clickOnAdd();
		dashboard.enterFirstName("Rushi");
		dashboard.enterLastName("Kapoor");
		dashboard.clickOnSave();
		dashboard.openAdminMenu();
		dashboard.clickOnAdminAdd();
		dashboard.typeForHints("Rushi");
		String empName = dashboard.getAdminTypeOption();
		Assert.assertEquals(empName,"Rushi Kapoor");

	}

}