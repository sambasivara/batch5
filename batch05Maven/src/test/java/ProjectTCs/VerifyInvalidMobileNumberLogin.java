package ProjectTCs;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import reusables.Common;
import reusables.ObjectRepository;
import reusables.Reusables;

public class VerifyInvalidMobileNumberLogin extends Common{
	private static final Logger logger = LogManager.getLogger(VerifyInvalidMobileNumberLogin.class); 

	ObjectRepository or;
String expectedTitle="Online Shopping India - Shop for clothes, shoes, Bags, watches @ Shoppersstop.com";
String inputText="1234567890";
String text="Please enter a valid mobile number.";
	@Test
	public void verifyInvalidMobileNumberLogin() throws IOException {
		try {
			or=new ObjectRepository(driver);
			driver.get("https://www.shoppersstop.com/");
			String actualTitle=driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			logger.info("Title verification pass");
			Reusables.captureScreenshot(driver, "PageVerified");
			Reusables.click(driver, or.loginIcon);
			Reusables.enterText(driver, or.mobileNoTxt, inputText);
			Reusables.click(driver, or.contunueBtn);
			Reusables.sleep(5);
			Reusables.verifyText(driver, or.invalidMessage, text);
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
