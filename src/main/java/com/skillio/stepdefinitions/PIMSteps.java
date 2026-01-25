package com.skillio.stepdefinitions;

import org.testng.Assert;

import com.skillio.base.Keyword;
import com.skillio.pages.Dashboard;
import com.skillio.utils.App;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PIMSteps {

	
	@When("User opens PIM Menu")
	public void openPIMModule(){
		Dashboard dashboard = new Dashboard();
		dashboard.openPIMMenu();
		dashboard.clickOnAdd();
	}
	
	
	@And("adds user with name Rishi Kapoor")
	public void addUser() {
		Dashboard dashboard = new Dashboard();
		dashboard.enterFirstName("Rushi");
		dashboard.enterLastName("Kapoor");
		
	}
	
	@And("save the details")
	public void saveTheDetails() {
		Dashboard dashboard = new Dashboard();
		dashboard.clickOnSave();
	}
	
	@Then("verify if the user is created with same name in Admin menu")
	public void verifyIfUserIsCreated() {
		Dashboard dashboard = new Dashboard();
		dashboard.openAdminMenu();
		dashboard.clickOnAdminAdd();
		dashboard.typeForHints("Rushi");
		String empName = dashboard.getAdminTypeOption();
		Assert.assertEquals(empName,"Rushi Kapoor");
	}
}
