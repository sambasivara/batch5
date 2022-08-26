package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//get the project location automatically
				String path=System.getProperty("user.dir");
				//set the driverexe location
				System.setProperty("webdriver.chrome.driver",path+"/src/test/resources/drivers/chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.get("https://courses.letskodeit.com/practice");
		
				Thread.sleep(2000);
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
				driver.findElement(By.id("bmwradio")).click();
				System.out.println("done");
				Thread.sleep(5000);
				driver.quit();
	}

}
