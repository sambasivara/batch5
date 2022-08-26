package reusables;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Common {
	public WebDriver driver = null;
	String browser = Constants.BROWSER_TYPE;
	
	protected static ExtentReports report;
	private static ExtentHtmlReporter htmlReporter;
	protected static ExtentTest extentLogger;

	@BeforeClass
	// Passing Browser parameter from TestNGxml
	public void beforeTest() {
		System.out.println("beforeClass");
		String path = System.getProperty("user.dir");
		// set the driverexe location
		if (browser.equals("GC")) {
			System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", path + "/src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("FF-Headless")) {
			System.setProperty("webdriver.gecko.driver", path + "/src/test/resources/drivers/geckodriver.exe");
			FirefoxOptions o = new FirefoxOptions();
			o.setHeadless(true);
			driver = new FirefoxDriver(o);
		}

		else if (browser.equals("GC-Headless")) {
			System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/drivers/chromedriver.exe");
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("headless");
			driver = new ChromeDriver(opt);

		} else {
			System.out
					.println("You have given worng parameter please provide GC or FF only, so executed on Chrome only");
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

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		// if any test fails, it can detect it,
		// take a screen shot at the point and attach to report
		if (result.getStatus() == ITestResult.FAILURE) {
			//Reusables.captureScreenshotOnFailure(driver, "googleSearchFailed")
			String screenshotLocation = Reusables.captureScreenshotOnFailurePath(driver,result.getName());
			extentLogger.fail(result.getName());
			extentLogger.addScreenCaptureFromPath(screenshotLocation);
			extentLogger.fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SKIP) {
			extentLogger.skip("Test Case Skipped: " + result.getName());
		}
		
	}

	@BeforeTest
	public void setUpTest() {
		report = new ExtentReports();
		// this is our custom location of the report that will be generated
		// report will be generated in the current project inside folder: test-output
		// report file name: report.html
		String timeStamp= new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String filePath = System.getProperty("user.dir") + "/src/test/resources/ExtentReports/report_"+timeStamp+".html";

		// initialize the htmlReporter with the path to the report
		htmlReporter = new ExtentHtmlReporter(filePath);

		// we attach the htmlreport to our report
		report.attachReporter(htmlReporter);

		report.setSystemInfo("Environment", "Test");
		report.setSystemInfo("Browser", browser);
		report.setSystemInfo("OS", System.getProperty("os.name"));

		report.setSystemInfo("QA Engineer", "Samba&Team");

		htmlReporter.config().setDocumentTitle("ABC Company Reports");
		htmlReporter.config().setReportName("Regaression Reports");

//        htmlReporter.config().setTheme(Theme.DARK);

	}
	@AfterTest
    public void tearDownTest() {
        report.flush();
    }

}
