package extentPractice;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import excePractice.GooglePage;
import reusables.Common;
import reusables.Constants;
import reusables.ObjectRepository;
import reusables.Reusables;

public class ExtentReportExample2 extends Common{
	private static final Logger logger = LogManager.getLogger(GooglePage.class); 

	ObjectRepository or;
	String expectedTitle;
	String inputText;
	@Test
	public void launchUrl() throws IOException {
		logger.info("Test execution started");
		or=new ObjectRepository(driver);
		extentLogger = report.createTest("ExtentReportExample2::launchUrl");
        
		extentLogger.info("Going to lanunch google page");
        driver.get("https://www.google.com");
		String actualTitle=driver.getTitle();
		expectedTitle=Reusables.readExcelData(Constants.EXCEL_PATH, "TestCases",2, 2);
		
		Assert.assertEquals(actualTitle, expectedTitle);
        extentLogger.info("TitleVerifed Successfuly");
       
        extentLogger .pass("Passed:launchUrl");
	}
	
	

}
