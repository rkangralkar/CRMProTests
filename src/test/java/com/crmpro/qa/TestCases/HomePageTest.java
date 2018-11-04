package com.crmpro.qa.TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crmpro.qa.Base.TestBase;
import com.crmpro.qa.pages.HomePage;
import com.crmpro.qa.pages.LoginPage;
import com.crmpro.qa.utilities.TestUtils;

import junit.framework.Assert;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtils testutil;
	

	public HomePageTest() {
		super();
	}

	@BeforeClass
	@Parameters({"Username","Password"})
	public void startBrowser(String username, String password) throws Exception {
		StartBrowser();
		loginpage = new LoginPage();
		testutil= new TestUtils();
		Thread.sleep(5000);
		homepage = loginpage.validLogin(username, password);
		Thread.sleep(2000);
	}
		
	@Test (groups = { "HomePageTest" }, priority=1)
	public void verifyHomePageTitle() throws Exception{
		TestUtils.takeScreenShot(".\\screenshots\\HomePageTest\\homepageTitle.png");
		Assert.assertEquals(homepage.homePageTitle(), "CRMPRO");
	}

	@Test (groups = { "HomePageTest" }, priority=2)
	public void verifyCRMPROlogoText() throws Exception{
		TestUtils.takeScreenShot(".\\screenshots\\HomePageTest\\verifyCRMPROlogoText.png");
		//Assert.assertEquals(homepage.getLogoText(), "CRMPRO");
		Assert.assertEquals("CRMPRO", homepage.getLogoText());
	}
	
	@AfterClass
	public void logout(){
		homepage.logout();
		driver.quit();
	}
}
