package testngPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestNGExample {

	@Test
	public void smapleTest() {
		
		try {
			String path=System.getProperty("user.dir");
			//set the driverexe location
			System.setProperty("webdriver.chrome.driver",path+"/src/test/resources/drivers/chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			driver.get("https://www.google.com");
			driver.findElement(By.xpath("")).click();
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void sampleTest2() throws InterruptedException {
		String path=System.getProperty("user.dir");
		//set the driverexe location
		System.setProperty("webdriver.chrome.driver",path+"/src/test/resources/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://courses.letskodeit.com/practice");

		Thread.sleep(2000);
		
		//the following element inside a frame, so first we have to change driver focuse to frame then find the element
		//switchto frame by using index
		//driver.switchTo().frame(0);
		//or second way by using id or name
		//driver.switchTo().frame("courses-iframe");
		//or third way by using xpath
		WebElement frame1=driver.findElement(By.xpath("//iframe[@name='iframe-name']"));
		driver.switchTo().frame(frame1);
		//dropdown handling
		//step1: create object for the select class
		Select categoryDD=new Select(driver.findElement(By.name("categories")));
		//step2: select option
		categoryDD.selectByIndex(2);
		Thread.sleep(5000);
		
		//after some task if you want to get back frome frame to default page then 
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		//Reusables.click(driver, driver.findElement(By.id("bmwradio")));
		driver.findElement(By.id("bmwradio")).click();
		System.out.println("done");
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void sampleTest3() throws InterruptedException {
		String path=System.getProperty("user.dir");
		//set the driverexe location
		System.setProperty("webdriver.chrome.driver",path+"/src/test/resources/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		//verify page title to confirm correct page is opened or not
		String title=driver.getTitle();
		System.out.println(title);
		
		//handling textbox
		driver.findElement(By.id("name")).sendKeys("Practice Makes");
		Thread.sleep(2000);
		driver.findElement(By.id("name")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("a man perfect");
		Thread.sleep(2000);
		String enteredValue=driver.findElement(By.id("name")).getAttribute("value");
		System.out.println(enteredValue);
		
		//handling checkbox
		driver.findElement(By.id("bmwcheck")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("hondacheck")).click();
		Thread.sleep(2000);
		boolean selectStatus=driver.findElement(By.id("bmwcheck")).isSelected();
		System.out.println(selectStatus);
		Thread.sleep(2000);
		boolean selectStatusBenz=driver.findElement(By.id("benzcheck")).isSelected();
		System.out.println(selectStatusBenz);
		
		//handling radio button
		driver.findElement(By.id("benzradio")).click();
		Thread.sleep(2000);
		boolean radioStatusBenz=driver.findElement(By.id("benzradio")).isSelected();
		System.out.println(radioStatusBenz);
		driver.findElement(By.id("hondaradio")).click();
		radioStatusBenz=driver.findElement(By.id("benzradio")).isSelected();
		System.out.println(radioStatusBenz);
		Thread.sleep(5000);
		driver.quit();
	}
}
