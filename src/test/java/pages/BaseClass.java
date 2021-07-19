package pages;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;

import utility.BrowserFactory;
import utility.ConfigurationDataProvider;
import utility.ExtentManager;
import utility.Helper;

public class BaseClass {
	public static WebDriver driver;
	public Actions act;
	public static ConfigurationDataProvider config;
	public String BrowserName;
	public Dimension dimension;
	
	static String fileName = System.getProperty("user.dir") + "/Reports/ExtentReports/TEST-"
			+ Helper.getCurrentDateTime() + ".html";
	public static ExtentReports extent = ExtentManager.createInstance(fileName);
	public static ExtentTest test;
	public static ExtentTest parenttest;
	public static ThreadLocal<ExtentTest> extentReport = new ThreadLocal<ExtentTest>();

	@BeforeSuite
	public void setUpSuite() {
		Reporter.log("IN BEFORE SUITE Executed", true);
	}

	@BeforeTest
	public void setBeforeTest() {
		Reporter.log("BEFORE TEST - Executed", true);
	}

	@Parameters("browser")
	@BeforeClass
	public void configTest(String browser) {
		System.out.println();
		config = new ConfigurationDataProvider();
		BrowserName = browser;
		driver = BrowserFactory.startApplication(driver, browser, config.getFromConfig("baseUrl"));
		
		dimension = new Dimension(1260, 820);
		driver.manage().window().setSize(dimension);
//		driver.manage().window().maximize();
		System.out.println("driver :" + driver);
		Reporter.log("BEFORE CLASS - Executed", true);
	}

	@BeforeMethod
	public void setBeforeMethod(Method method) {
		Reporter.log("\nBEFORE METHOD - Executed", true);
	}

	@AfterMethod
	public void setAfterMethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			extentReport.get().fail("TEST FAILED @ " + BrowserName,
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentReport.get().pass("Test PASSED",
					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		Reporter.log("AFTER METHOD  - Executed\n", true);
	}

	@AfterClass
	public void setAfterClass() throws IOException {
		System.out.println("driver :" + driver);
		BrowserFactory.quitBrowser(driver);
		Reporter.log("AFTER CLASS - Executed", true);
	}

	@AfterTest
	public void setAfterTest() throws IOException {

		Reporter.log("AFTER TEST - Executed", true);
	}

	@AfterSuite
	public void setAfterSuite() throws IOException {
		Reporter.log("AFTER SUITE - Executed", true);
	}
}