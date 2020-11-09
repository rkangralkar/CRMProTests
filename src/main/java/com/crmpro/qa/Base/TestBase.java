package com.crmpro.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Parameters;

import com.crmpro.qa.utilities.TestUtils;
import com.crmpro.qa.utilities.WebEventListener;

public class TestBase {

	public static WebDriver driver = null;
	public static Properties prop;
	public static String config_file_path = "C:\\Users\\Admin\\workspace\\CRMProTest\\src\\main\\java\\com\\crmpro\\qa\\config\\config.properties";
	static String chromeDriver_path = ".\\drivers\\chromedriver.exe";
	static String edgeDriver_path = ".\\drivers\\MicrosoftWebDriver.exe";
	static String firefoxDriver_path = ".\\drivers\\geckodriver.exe";
	static EventFiringWebDriver e_driver;
	static WebEventListener eventListener;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(config_file_path);
			prop.load(fis);

		} catch (FileNotFoundException e) {
			System.out.println("The config file not found at given location : " + config_file_path);
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("There is some IO exception while handling config file. Please verify the config file");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}

	}

	@Parameters({"browser"})
	public static void StartBrowser() {

		 String browserName = prop.getProperty("browser");
		// if (driver == null) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriver_path);
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("microsoft edge")) {
			System.setProperty("webdriver.edge.driver", edgeDriver_path);
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", firefoxDriver_path);
			driver = new FirefoxDriver();
		}
		// }

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_TO_LOAD, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));

	}
}
