package actions;

import org.openqa.selenium.WebDriver;

import reusables.ObjectRepository;
import reusables.Reusables;

public class FunctionalReusables {

	public void loginIntoSauce(WebDriver driver,ObjectRepository webelements,String username,String password) {
		Reusables.enterText(driver,webelements.usernameTxt, username);
		Reusables.enterText(driver,webelements.passwordTxt, password);
		Reusables.click(driver, webelements.loginBtn);
	}
}
