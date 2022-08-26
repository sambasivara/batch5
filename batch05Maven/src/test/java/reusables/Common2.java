package reusables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Common2 {
	public WebDriver driver = null;
	//String browser="GC";
	@Parameters("browser")
	@BeforeClass
	//Passing Browser parameter from TestNGxml
	public void beforeTest(String browser) {
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

	@AfterClass
	public void tearDownClass() {
		System.out.println("AfterClass");
		driver.quit();
	}
}
