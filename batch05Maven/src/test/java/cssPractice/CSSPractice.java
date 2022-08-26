package cssPractice;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import reusables.Common;
import reusables.Constants;
import reusables.ObjectRepository;
import reusables.Reusables;

public class CSSPractice extends Common{
	private static final Logger logger = LogManager.getLogger(CSSPractice.class);
	ObjectRepository or;
	String expectedTitle;
	String firtname;
	String email;
	@Test
	public void cssPractice() throws Exception {
		try {
			or=new ObjectRepository(driver);
			
			extentLogger = report.createTest("CSSPractice::cssPractice");
			
			driver.get("https://www.monsterindia.com/seeker/registration?");
			extentLogger.info("URL loaded");
			String actualTitle=driver.getTitle();
			expectedTitle=Reusables.readExcelData(Constants.EXCEL_PATH, "TestCases", 3, 2);
			Assert.assertEquals(actualTitle, expectedTitle);
			extentLogger.info("Title verification done");
			Reusables.captureScreenshot(driver, "cssPractice_title");
			firtname=Reusables.readExcelData(Constants.EXCEL_PATH, "TestCases", 3, 3);
			Reusables.enterText(driver, or.firstName, firtname);
			email=Reusables.readExcelData(Constants.EXCEL_PATH, "TestCases", 3, 6);
			Reusables.enterText(driver, or.email, email);
			extentLogger.info("details entered: done");
			
			extentLogger.pass("Passed:cssPractice");
			Reusables.captureScreenshot(driver, "cssPractice_pass");
			Reusables.writeIntoExcel(Constants.EXCEL_PATH, "TestCases", 3, 5,"passed");
			logger.info("done");
		} catch (AssertionError|Exception e) {
			e.printStackTrace();
			Reusables.captureScreenshotOnFailure(driver, "cssPractice");
			Reusables.writeIntoExcel(Constants.EXCEL_PATH, "TestCases", 3, 5,"Failed");
			driver.quit();
			throw new Exception();
		}
	}
}
