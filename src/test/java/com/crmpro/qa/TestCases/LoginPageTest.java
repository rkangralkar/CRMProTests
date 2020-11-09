package com.crmpro.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crmpro.qa.Base.TestBase;
import com.crmpro.qa.pages.HomePage;
import com.crmpro.qa.pages.LoginPage;
import com.crmpro.qa.utilities.TestUtils;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	TestUtils testUtil;
	HomePage homePage;
	
	
	public LoginPageTest() {
		super();
	}

	@BeforeClass
	public void startBrowser() {
		StartBrowser();
		loginPage = new LoginPage();
		testUtil = new TestUtils();
	}

	@Test(priority = 1)
	public void validateLoginPageTitle() throws Exception {
		Thread.sleep(2000);
		System.out.println("webpage title is " + loginPage.loginPageTitle());
		String title = loginPage.loginPageTitle();
		boolean result = title.contains("customer relationship management, sales,");
		Assert.assertEquals(result, true);
		Thread.sleep(2000);
	}

	@Test(priority = 2, enabled = true)
	public void validateLoginPageLOGO() throws Exception {
		Assert.assertEquals(loginPage.validateLoginPageLOGO(), true);
	}
	
	@Test(priority = 3, enabled = true)
	public void validLogin() throws Exception {
		Thread.sleep(2000);
		homePage = loginPage.validLogin(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
		System.out.println(homePage.homePageTitle());
		Assert.assertEquals(homePage.homePageTitle(), "CRMPRO");;
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
