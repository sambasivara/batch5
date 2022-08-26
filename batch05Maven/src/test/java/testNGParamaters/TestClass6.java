package testNGParamaters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import reusables.Constants;

public class TestClass6{

	
	public WebDriver driver = null;
	String browser=Constants.BROWSER_TYPE;
	@BeforeMethod
	//Passing Browser parameter from TestNGxml
	public void beforeTest() {
		System.out.println("beforeClass");
		String path = System.getProperty("user.dir");
		// set the driverexe location
		if(browser.equals("GC")) {
			System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if(browser.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", path + "/src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}		
		else {
			System.out.println("You have given worng parameter please provide GC or FF only, so executed on Chrome only");
			System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDownClass() {
		System.out.println("AfterClass");
		driver.quit();
	}
	@Test
	public void smapleTest() {
			System.out.println("@Test sampleTest");
			driver.get("https://www.shoppersstop.com");
			//implementation code
						
	}
	
	@Test
	public void smapleTest2() {
			System.out.println("@Test sampleTest");
			driver.get("https://www.google.com");
			//implementation code
						
	}
	
	@Test
	public void smapleTest3() {
			System.out.println("@Test sampleTest");
			driver.get("https://www.facebook.com");
			//implementation code
						
	}
}
