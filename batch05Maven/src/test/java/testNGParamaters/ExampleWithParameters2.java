package testNGParamaters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExampleWithParameters2 {

	
	WebDriver driver = null;
	@Test
	public void smapleTest() {
			System.out.println("@Test sampleTest");
			driver.get("https://www.google.com");
	}

	
	@BeforeMethod
	public void setup() {
		System.out.println("beforeMethod");
		
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("AfterMethod");		
	}
	
	
	@Parameters("browser")
	@BeforeClass
	//Passing Browser parameter from TestNGxml
	public void beforeTest(@Optional("optionalParames")String browser) {
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
		
		else if(browser.equals("FF-Headless")) {
			System.setProperty("webdriver.gecko.driver", path + "/src/test/resources/drivers/geckodriver.exe");
			FirefoxOptions o = new FirefoxOptions();
			o.setHeadless(true);
			driver = new FirefoxDriver(o);
		}
		
		else if(browser.equals("GC-Headless")) {
			System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/drivers/chromedriver.exe");
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("headless");
			driver = new ChromeDriver(opt);
			
		}
		else {
			System.out.println("You have given worng parameter please provide GC or FF only, so executed on Chrome only");
			System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDownClass() {
		System.out.println("AfterClass");
		driver.quit();
	}
}
