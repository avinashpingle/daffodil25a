package com.skillio.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skillio.base.DriverManager;
import com.skillio.repo.Locator;
import com.skillio.utils.WaitFor;

public class Dashboard {
	
	@FindBy(xpath = "//a[@href=\"/web/index.php/pim/viewPimModule\"]")
	WebElement viewPIMMenu;
	
	@FindBy(xpath ="//button[text()=' Add ']")
	WebElement addBtn;
	
	/*
	 * Create more WebElements as mentioned in Locator.java interface
	 */
	
	@FindBy(xpath = "//input[@name=\"firstName\"]")
	WebElement firstName;

	@FindBy(xpath = "//input[@name=\"lastName\"]")
	WebElement lastName;

	@FindBy(xpath = "//button[text()=' Save ']")
	WebElement saveBtn;

	@FindBy(xpath = "//a[@href=\"/web/index.php/admin/viewAdminModule\"]")
	WebElement adminMenu;

	@FindBy(xpath ="//button[text()=' Add ']")
	WebElement adminAddBtn;

	@FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
	WebElement typeForHints;

	@FindBy(xpath = "//div[@role=\"option\"]/descendant::span")
	List<WebElement> adminTypeOptions;
	
	public Dashboard() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	// --- Interaction methods ---

	public void openPIMMenu() {
		WaitFor.presenceOfElement(Locator.viewPIMMenu);
		viewPIMMenu.click();
	}

	public void clickOnAdd() {
		WaitFor.presenceOfElement(Locator.addBtn);
		addBtn.click();
	}

	public void enterFirstName(String fName) {
		WaitFor.presenceOfElement(Locator.firstName);
		firstName.clear();
		firstName.sendKeys(fName);
	}

	public void enterLastName(String lName) {
		WaitFor.presenceOfElement(Locator.lastName);
		lastName.clear();
		lastName.sendKeys(lName);
	}

	public void clickOnSave() {
		WaitFor.presenceOfElement(Locator.saveBtn);
		saveBtn.click();
	}

	/**
	 * Convenience method to create an employee: opens PIM, clicks Add, fills names and saves.
	 */
	public void addEmployee(String fName, String lName) {
		openPIMMenu();
		clickOnAdd();
		enterFirstName(fName);
		enterLastName(lName);
		clickOnSave();
	}

	public void openAdminMenu() {
		WaitFor.presenceOfElement(Locator.adminMenu);
		adminMenu.click();
	}

	public void clickOnAdminAdd() {
		WaitFor.presenceOfElement(Locator.adminAddBtn);
		adminAddBtn.click();
	}

	public void typeForHints(String text) {
		WaitFor.presenceOfElement(Locator.typeForHints);
		typeForHints.clear();
		typeForHints.sendKeys(text);
		
	}

	/**
	 * Selects an option from the admin type dropdown/list by visible text.
	 * If exact match is not found, it will try a contains() match (case-insensitive).
	 */
	public boolean selectAdminType(String visibleText) {
		WaitFor.presenceOfElement(Locator.adminTypeOption);
		for (WebElement el : adminTypeOptions) {
			String txt = el.getText();
			if (txt == null) continue;
			if (txt.equalsIgnoreCase(visibleText) || txt.toLowerCase().contains(visibleText.toLowerCase())) {
				el.click();
				return true;
			}
		}
		return false; // not found
	}

	public String getAdminTypeOption() {
		for (WebElement adminTypeOption : adminTypeOptions) {
			String type = adminTypeOption.getText();
			if(type.equalsIgnoreCase("Avinash")){
				return type;
			}
		}
		return null;
	}

}