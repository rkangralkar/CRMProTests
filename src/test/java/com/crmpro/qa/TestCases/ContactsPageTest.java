package com.crmpro.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crmpro.qa.Base.TestBase;
import com.crmpro.qa.pages.ContactsPage;
import com.crmpro.qa.pages.HomePage;
import com.crmpro.qa.pages.LoginPage;
import com.crmpro.qa.utilities.TestUtils;

public class ContactsPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactpage;
	TestUtils testUtil;

	public ContactsPageTest() {
		super();
	}

	@BeforeClass
	public void initializeBrowser() throws Exception {
		StartBrowser();
		loginpage = new LoginPage();
		testUtil= new TestUtils();
		Thread.sleep(2000);
		homepage = loginpage.validLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		contactpage = homepage.gotoContactsPage();
	}

	@Test
	public void getValue() throws Exception {
		TestUtils.takeScreenShot(".\\screenshots\\ContactsPageTest\\contactsPage.png");
		Assert.assertEquals(contactpage.getString(), "Load From Company");
	}

	@AfterClass
	public void tearDown() {
		homepage.logout();
		driver.quit();
	}

}
