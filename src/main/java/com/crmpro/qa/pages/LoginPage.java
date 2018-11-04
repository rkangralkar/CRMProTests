package com.crmpro.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crmpro.qa.Base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement userID;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//a[@class='navbar-brand']")
	WebElement CRMlogo;

	public boolean validateLoginPageLOGO() {
		System.out.println(CRMlogo.getAttribute("href"));
		return CRMlogo.isDisplayed();
	}

	public String loginPageTitle() {
		return driver.getTitle();
	}

	public HomePage validLogin(String UID, String PW) throws Exception {
		
		userID.sendKeys(UID);
		password.sendKeys(PW);
		Thread.sleep(2000);
		loginButton.click();
		return new HomePage();

	}

}
