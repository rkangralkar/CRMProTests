package com.crmpro.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmpro.qa.Base.TestBase;

public class ContactsPage extends TestBase {

	public ContactsPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='Load From Company']")
	WebElement LoadFromCompany;

	public String getString() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainpanel");
		return LoadFromCompany.getAttribute("value");

	}

}
