package reusables;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Reusables {
	private static final Logger logger = LogManager.getLogger(Reusables.class);
	static String projectPath=System.getProperty("user.dir");
	
	public static void captureScreenshot(WebDriver driver,String name) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		File scr1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr1, new File(projectPath+"\\screenshots\\pass\\"+name+"_"+timeStamp+".png"));
		logger.info("Screenshot caputured successfully");
	}
		
	public static void captureScreenshotOnFailure(WebDriver driver,String screenshotName) throws IOException{
		String timeStamp= new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		//String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//copy this scr file into given location. It accept two arguments like souce and destination
		FileUtils.copyFile(scr, new File(projectPath+"\\screenshots\\fail\\"+screenshotName+"_"+timeStamp+".jpg"));
		logger.info("Screenshot caputured successfully");
	}
	
	public static String captureScreenshotOnFailurePath(WebDriver driver,String screenshotName) throws IOException{
		String timeStamp= new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		//String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//copy this scr file into given location. It accept two arguments like souce and destination
		FileUtils.copyFile(scr, new File(projectPath+"\\screenshots\\fail\\"+screenshotName+"_"+timeStamp+".jpg"));
		String path=projectPath+"\\screenshots\\fail\\"+screenshotName+"_"+timeStamp+".jpg";
		return path;
	}
	
	public void normalMethod() {
		System.out.println("This is normal method");
	}
	
	public static void click(WebDriver driver,WebElement ele) {
		//highlight an element, wait for element explicitly
		logger.info("Going to click on :"+ele);
		highliter(driver, ele);
		ele.click();
		logger.info("Clicked on element successfully:"+ele);	
		//page load
	}
	public static void handleDropdown(WebDriver driver,WebElement ele,String option) {
		logger.info("Going to handle the dropdown :"+ele);
		highliter(driver, ele);
		Select dd=new Select(ele);
		dd.selectByValue(option);
		logger.info("dropdown has selected option :"+option);
	}
	public static void handleDropdown(WebDriver driver,WebElement ele,int index) {
		logger.info("Going to handle the dropdown :"+ele);
		highliter(driver, ele);
		Select dd=new Select(ele);
		dd.selectByIndex(index);
		logger.info("dropdown has selected option :"+index);
	}
	
	public static void enterText(WebDriver driver,WebElement ele,String text) {
		logger.info("Going to enter text in text box of:"+ele);
		highliter(driver, ele);
		ele.sendKeys(text);
		logger.info("successfuly entered text: "+text);
	}

	public static void highliter(WebDriver driver,WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        //use executeScript() method and pass the arguments 
        //Here i pass values based on css style. Yellow background color with solid red color border. 
	   js.executeScript("arguments[0].setAttribute('style', 'border: 5px solid blue;');", ele);
	}
	
	public static boolean isDisplayed(WebDriver driver,WebElement ele) {
		logger.info("Going to verify is some element displayed or not"+ele);
		highliter(driver, ele);
		if(ele.isDisplayed())
		{
			logger.info("Element displayed successfully");
			return true;
		}
		else {
			logger.info("Element is NOT displayed successfully");
			return false;
		}
		
	}
	
	public static boolean verifyText(WebDriver driver,WebElement ele,String expectedText) {
		logger.info("Going to verify is some element displayed or not"+ele);
		highliter(driver, ele);
		String actualText=ele.getText();
		if(actualText.contains(expectedText))
		{	logger.info("Text verification done successfully");
			return true;
		}
		else {
			logger.info("Text verification failed");
			return false;
		}
		
	}
	
	public static void sleep(int seconds) throws InterruptedException {
		Thread.sleep(seconds*1000);
	}
	
	public static String readExcelData(String filepath,String sheetName,int rowNo,int colNo) throws IOException {
		// give the path of the excel file to read
		FileInputStream fis = new FileInputStream(filepath);
		// create object for workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// get excel sheet
		XSSFSheet st = wb.getSheet(sheetName);
		// read data from excel sheet row and column wise
		String data = st.getRow(rowNo).getCell(colNo).toString();
		logger.info("excel data is:" + data);
		wb.close();
		fis.close();
		return data;
	}
	
	public static boolean writeIntoExcel(String filePath,String sheetName,int rowNo,int cellNo,String status) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		// create object for workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// create a sheet
		XSSFSheet st = wb.getSheet(sheetName);
		// create a cell or column data
		XSSFCell cl = st.getRow(rowNo).createCell(cellNo);
		cl.setCellValue(status);
		// save or write data into file
		// Write a data into file
		fis.close();
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
		//wb.close();		// close file
		fos.close();
		logger.info("Status updated Successfully");
		return false;

	}
}
