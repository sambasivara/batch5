package testngPractice;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PreorityTests {

	@Test(priority = 1)
	public void loginGmail() {
		System.out.println("Contain login funtinality code, like username, password, login button");		
	}
	
	//@Parameters("productName")
	@Test(priority = 5,dependsOnMethods = { "loginGmail","compuseMail"})
	//public void deleteMail(String productName) {
	public void deleteMail() {
		//System.out.println(productName);
		System.out.println("This is the functional deleteMail test cases");
	}
	
	@Test(priority = 3,dependsOnMethods = "loginGmail")
	public void searchMail() {
		System.out.println("This is the functional searchMail test cases");
	}
	
	@Test(priority = 4,dependsOnMethods = "loginGmail")
	public void verifyEmail() {
		System.out.println("This is the functional verifyEmail test cases");
	}
	
	@Test(priority = 2,dependsOnMethods = "loginGmail")
	public void compuseMail() {
		System.out.println("This is the functional compuseMail test cases");
		Assert.assertTrue(false);
	}
	
	
}
