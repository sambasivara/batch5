package reusables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjectRepository {

	public ObjectRepository(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//saucedemo
	@FindBy(id="user-name") public WebElement usernameTxt;
	@FindBy(id="password") public WebElement passwordTxt;
	@FindBy(id="login-button") public WebElement loginBtn;
	@FindBy(id="shopping_cart_container") public WebElement shoppingIcon;
	@FindBy(id="react-burger-menu-btn") public WebElement burgerMenuBtn;
	@FindBy(id="inventory_sidebar_link") public WebElement menuOption1;
	@FindBy(id="about_sidebar_link") public WebElement menuOption2;
	@FindBy(id="logout_sidebar_link") public WebElement menuOption3;
	@FindBy(id="reset_sidebar_link") public WebElement menuOption4;
	@FindBy(id="add-to-cart-sauce-labs-backpack") public WebElement addTocart;
	
	//google page
	@FindBy(name = "q") public WebElement searchBox;
	@FindBy(name= "btnK") public WebElement searchBtn;
	@FindBy(xpath = "//span[text()='All']") public WebElement verifyAll;
	
	//shoppersstop
	@FindBy(className = "user") public WebElement loginIcon;
	@FindBy(id = "mobileNumber") public WebElement mobileNoTxt;
	@FindBy(xpath = "(//button[@class='primary-cta show_desktop'])[1]") public WebElement contunueBtn;
	@FindBy(className ="invalid-feedback") public WebElement invalidMessage;
	
	//monstor page
	@FindBy(css = "input[name='fullname']") public WebElement firstName;
	@FindBy(css = ".input.email-autocomplete-input") public WebElement email;
	@FindBy(className = "upload-file") public WebElement uploadBtn;
}
