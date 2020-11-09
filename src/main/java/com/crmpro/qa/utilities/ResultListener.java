package com.crmpro.qa.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crmpro.qa.Base.TestBase;

public class ResultListener extends TestBase implements ITestListener, ISuiteListener {

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result, WebDriver driver) {
		System.out.println(result.getName() + " has successfully passed");

	}

	public void onTestFailure(ITestResult result) {

		System.out.println(result.getTestName() + " has failed");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File(".\\screenshots\\" + result.getName() + ".jpg"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName() + " has skipped due to "+ITestResult.FAILURE);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		System.out.println("Execution of " + context.getName() + " has started");

	}

	public void onFinish(ITestContext context) {
		
		System.out.println("Execution of " + context.getName() + " has completed");

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ISuite suite) {

	}

	public void onFinish(ISuite suite) {
		driver.quit();

	}

}
