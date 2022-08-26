package ProjectTCs;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import reusables.Common;
import reusables.ObjectRepository;
import reusables.Reusables;

public class Amazon extends Common{
	private static final Logger logger = LogManager.getLogger(Amazon.class); 

	ObjectRepository or;
String expectedTitle="Google";
String inputText="selenium";
	@Test
	public void googleSearch() throws IOException {
		try {
			or=new ObjectRepository(driver);
			driver.get("https://www.amazon.in/");
			String actualTitle=driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			logger.info("Title verification pass");
			
			
			Reusables.enterText(driver, or.searchBox, inputText);
			Reusables.click(driver, or.searchBtn);
			Reusables.sleep(5);
			Reusables.isDisplayed(driver, or.verifyAll);
			Reusables.captureScreenshot(driver, "PassedGoogleSearch");
			logger.info("Search has done successfully");
		} catch (AssertionError|Exception e) {
			logger.error("search got failed due to some error");
			e.printStackTrace();
			Reusables.captureScreenshotOnFailure(driver, "googleSearchFailed");
			driver.quit();
		}
		
	}
}
