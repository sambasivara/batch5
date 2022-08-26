package excePractice;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import reusables.Common;
import reusables.Constants;
import reusables.ObjectRepository;
import reusables.Reusables;

public class VerifyInvalidMobileNumberLogin extends Common{
	private static final Logger logger = LogManager.getLogger(VerifyInvalidMobileNumberLogin.class); 

	ObjectRepository or;
String expectedTitle;
String inputText;
String errorMessage;
	@Test
	public void verifyInvalidMobileNumberLogin() throws IOException {
		try {
			or=new ObjectRepository(driver);
			expectedTitle=Reusables.readExcelData(Constants.EXCEL_PATH, "TestCases", 1, 2);
			inputText=Reusables.readExcelData(Constants.EXCEL_PATH, "TestCases", 1, 3);
			errorMessage=Reusables.readExcelData(Constants.EXCEL_PATH, "TestCases", 1, 4);
			driver.get("https://www.shoppersstop.com/");
			String actualTitle=driver.getTitle();			
			Assert.assertEquals(actualTitle, expectedTitle);
			logger.info("Title verification pass");
			Reusables.captureScreenshot(driver, "PageVerified");
			Reusables.click(driver, or.loginIcon);
			Reusables.enterText(driver, or.mobileNoTxt, inputText);
			Reusables.click(driver, or.contunueBtn);
			Reusables.sleep(5);
			Reusables.verifyText(driver, or.invalidMessage, errorMessage);
			Reusables.captureScreenshot(driver, "verifyInvalidMobileNumberLoginPass");
			logger.info("Search has done successfully");
		} catch (AssertionError|Exception e) {
			logger.error("search got failed due to some error");
			e.printStackTrace();
			Reusables.captureScreenshotOnFailure(driver, "verifyInvalidMobileNumberLoginFailed");
			driver.quit();
		}
		
	}
}
