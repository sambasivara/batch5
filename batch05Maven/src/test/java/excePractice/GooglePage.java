package excePractice;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import reusables.Common;
import reusables.Constants;
import reusables.ObjectRepository;
import reusables.Reusables;

public class GooglePage extends Common{

	private static final Logger logger = LogManager.getLogger(GooglePage.class); 

ObjectRepository or;
String expectedTitle;
String inputText;
	@Test
	public void googleSearch() throws Exception {
		try {
			or=new ObjectRepository(driver);
			driver.get("https://www.google.com");
			String actualTitle=driver.getTitle();
			expectedTitle=Reusables.readExcelData(Constants.EXCEL_PATH, "TestCases",2, 2);
			inputText=Reusables.readExcelData(Constants.EXCEL_PATH, "TestCases",2, 3);
			Assert.assertEquals(actualTitle, expectedTitle);
			logger.info("Title verification pass");
			Reusables.enterText(driver, or.searchBox, inputText);
			Reusables.click(driver, or.searchBtn);
			Reusables.sleep(5);
			Reusables.isDisplayed(driver, or.verifyAll);
			Reusables.captureScreenshot(driver, "PassedGoogleSearch");
			Reusables.writeIntoExcel(Constants.EXCEL_PATH, "TestCases",2, 5,"Passed");
			logger.info("Search has done successfully");
		} catch (AssertionError|Exception e) {
			logger.error("search got failed due to some error");
			e.printStackTrace();
			Reusables.captureScreenshotOnFailure(driver, "googleSearchFailed");
			Reusables.writeIntoExcel(Constants.EXCEL_PATH, "TestCases",2, 5,"Failed");
			driver.quit();
			throw new Exception();
		}
		
	}
}
