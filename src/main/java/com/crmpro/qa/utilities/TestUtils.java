package com.crmpro.qa.utilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crmpro.qa.Base.TestBase;

public class TestUtils extends TestBase {

	public static int PAGE_TO_LOAD = 25;
	public static int IMPLICIT_WAIT = 10;

	public static void takeScreenShot(String path) throws Exception {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, new File(path));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
