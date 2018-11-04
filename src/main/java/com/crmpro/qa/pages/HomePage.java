package com.crmpro.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmpro.qa.Base.TestBase;

public class HomePage extends TestBase {

	static Actions act;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='dispAlertMessage']//following-sibling::table[1]/tbody/tr[2]/td[1]//td[1]")
	WebElement CRMPROlogo;

	@FindBy(xpath = "//a[contains(@href,'logout')]")
	WebElement logout;

	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement ContactsLink;

	@FindBy(xpath = "//a[@title='New Contact']")
	WebElement NewContact;

	public String getLogoText() {
		driver.switchTo().frame("mainpanel");
		String text = CRMPROlogo.getText();
		driver.switchTo().defaultContent();
		return text;
	}

	public String homePageTitle() {
		return driver.getTitle();
	}

	public void logout() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("mainpanel");
		logout.click();

	}

	public ContactsPage gotoContactsPage() throws Exception {
		Thread.sleep(3000);
		driver.switchTo().frame("mainpanel");
		act= new Actions(driver);
		act.moveToElement(ContactsLink).build().perform();
		Thread.sleep(2000);
		NewContact.click();
		return new ContactsPage();

	}

}
