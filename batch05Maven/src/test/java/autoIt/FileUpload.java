package autoIt;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import reusables.Common;
import reusables.Constants;
import reusables.ObjectRepository;
import reusables.Reusables;

public class FileUpload extends Common{
	private static final Logger logger = LogManager.getLogger(FileUpload.class);
	ObjectRepository or;
	String expectedTitle;
	String firtname;
	String email;
	@Test
	public void fileUpload() throws Exception {
		try {
			or=new ObjectRepository(driver);
			
			extentLogger = report.createTest("FileUpload::fileUpload");
			
			driver.get("https://www.monsterindia.com/seeker/registration?");
			extentLogger.info("URL loaded");
			String actualTitle=driver.getTitle();
			expectedTitle=Reusables.readExcelData(Constants.EXCEL_PATH, "TestCases", 4, 2);
			Assert.assertEquals(actualTitle, expectedTitle);
			extentLogger.info("Title verification done");
			Reusables.captureScreenshot(driver, "cssPractice_title");
			firtname=Reusables.readExcelData(Constants.EXCEL_PATH, "TestCases", 4, 3);
			Reusables.enterText(driver, or.firstName, firtname);
			email=Reusables.readExcelData(Constants.EXCEL_PATH, "TestCases", 4, 6);
			Reusables.enterText(driver, or.email, email);
			Reusables.click(driver, or.uploadBtn);
			Reusables.sleep(2);
			Runtime.getRuntime().exec("E:\\SeleniumJavaClasses\\Batch5\\AutoIT\\uploadFile.exe");
			Reusables.sleep(5);
			extentLogger.info("details entered");
			
			extentLogger.pass("Passed:cssPractice");
			Reusables.captureScreenshot(driver, "cssPractice_pass");
			Reusables.writeIntoExcel(Constants.EXCEL_PATH, "TestCases", 4, 5,"passed");
			
		} catch (AssertionError|Exception e) {
			e.printStackTrace();
			Reusables.captureScreenshotOnFailure(driver, "cssPractice");
			Reusables.writeIntoExcel(Constants.EXCEL_PATH, "TestCases", 4, 5,"Failed");
			driver.quit();
			throw new Exception();
		}
	}
}
