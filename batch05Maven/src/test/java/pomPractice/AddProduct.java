package pomPractice;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import actions.FunctionalReusables;
import reusables.Common;
import reusables.Constants;
import reusables.ObjectRepository;
import reusables.Reusables;

public class AddProduct extends Common{
String expectedTitle="Swag Labs";
ObjectRepository webelements;
FunctionalReusables functionalReusables;
	@Test(priority = 1)
	public void login() throws IOException {
		try {
			webelements=new ObjectRepository(driver);
			functionalReusables=new FunctionalReusables();
			driver.get(Constants.urlS);
			String actualTitle=driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle,"Page title is miss matched, wrong page opned. Please check url");
			functionalReusables.loginIntoSauce(driver, webelements, Constants.usernameS, Constants.passwordS);
			Assert.assertTrue(Reusables.isDisplayed(driver,webelements.shoppingIcon));
			Reusables.captureScreenshot(driver, "LoginPassed");
		} catch (AssertionError|Exception e) {
			e.printStackTrace();
			System.out.println("failed due to AssertionError");
			Reusables.captureScreenshotOnFailure(driver, "FailedLogin");
			driver.quit();			
		}
	}
	
	@Test(priority = 2,dependsOnMethods = "login")
	public void verifyLogindetails() throws IOException {
		try {
			Reusables.click(driver,webelements.burgerMenuBtn);
			Reusables.sleep(5);
			Assert.assertTrue(Reusables.isDisplayed(driver,webelements.menuOption1));
			Assert.assertTrue(Reusables.isDisplayed(driver,webelements.menuOption2));
			Assert.assertTrue(Reusables.isDisplayed(driver,webelements.menuOption3));
			Assert.assertTrue(Reusables.isDisplayed(driver,webelements.menuOption4));
			Reusables.captureScreenshot(driver, "VerifiedLoginDetails");
		} catch (AssertionError|Exception e) {
			e.printStackTrace();
			System.out.println("failed due to AssertionError");
			Reusables.captureScreenshotOnFailure(driver, "FailedLogin");
			driver.quit();
		}
		
	}
	
	}
