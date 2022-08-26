package testngPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGExampleWithBeforeAfterClass {
	WebDriver driver = null;
	@Test
	public void smapleTest() {

		
			System.out.println("@Test sampleTest");
			driver.get("https://www.google.com");
			driver.findElement(By.xpath("dfghjhg")).click();
		

	}

	@Test
	public void sampleTest2() throws InterruptedException {
		System.out.println("@Test sampleTest2");
		driver.get("https://www.facebook.com");
//implmentation
		Thread.sleep(2000);
		System.out.println("done");
		Thread.sleep(5000);
	}

	@Test
	public void sampleTest3() throws InterruptedException {
		System.out.println("@Test sampleTest3");
		driver.get("https://courses.letskodeit.com/practice");
		
	}
	
	@BeforeMethod
	public void setup() {
		System.out.println("beforeMethod");
		
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("AfterMethod");		
	}
	
	@BeforeClass
	public void setupClass() {
		System.out.println("beforeClass");
		String path = System.getProperty("user.dir");
		// set the driverexe location
		System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDownClass() {
		System.out.println("AfterClass");
		driver.quit();
	}
	
}
