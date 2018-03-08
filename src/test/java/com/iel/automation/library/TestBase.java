package com.iel.automation.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.iel.automation.constants.Constants;
import com.iel.automation.utilities.ExcelReader;
import com.iel.automation.utilities.IelException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


@Listeners({com.iel.automation.utilities.RetryListner.class,com.iel.automation.utilities.IelListener.class})


public class TestBase {

	public static WebDriverWait wait;

	public static Properties appConfig = new Properties();
	public static WebDriver driver;

	public static FileInputStream fis;
	public static ExtentReports extent;
	public static ExtentTest test;
	ExcelReader excel = new ExcelReader();
	public static Map<String, Map<String, String>> testData = new HashMap<>();

	public static final String ERROR_SCREENSHOT = "Unable to take screenshot : ";
	public static final String SCREENSHOT_FOLDER_NAME = "test-output\\Screenshots";
	public static final String PATH_SEPARATOR = "_";
	public static final String SCREENSHOT_FILETYPE = ".png";
	public static final String LOADPROPERTIES_ERROR = "Error in loading properties files";

	public TestBase() throws IelException {
		loadAppProperties();
		testData = excel.getInputSheetIntoMap();
		PageFactory.initElements(driver, this);
	}

	@BeforeSuite
	public void reportSetup() {
		extent = new ExtentReports(Constants.EXTENT_OUTPUT_REPORT_PATH, true);
		extent.loadConfig(new File(Constants.REPORTCONFIG_FILE_PATH));
		

	}

	@BeforeMethod
	public void setUp(Method method) {

		/** select the browser **/

		test = extent.startTest(method.getAnnotation(Test.class).description());

		if (appConfig.getProperty(Constants.BROWSER_NAME).equals(Constants.FF_BROWSER)) {
			System.setProperty(Constants.FF_SYSTEM_PROPERTY, Constants.GECKODRIVER_EXE_PATH);

			driver = new FirefoxDriver();

		} else if (appConfig.getProperty(Constants.BROWSER_NAME).equals(Constants.CHROME_BROWSER)) {

			System.setProperty(Constants.CHROME_SYSTEM_PROPERTY, Constants.CHROMEDRIVER_EXE_PATH);
			driver = new ChromeDriver();
		} else if (appConfig.getProperty(Constants.BROWSER_NAME).equals(Constants.IE_BROWSER)) {

			System.setProperty(Constants.IE_SYSTEM_PROPERTY, Constants.IEDRIVER_EXE_PATH);
			driver = new InternetExplorerDriver();
		}

		/** select the application **/

		if (appConfig.getProperty(Constants.APPLICATION_NAME).equals(Constants.ILMSDEVQAMSA)) {
			driver.get(appConfig.getProperty(Constants.ILMSDEVQAMSA_URL));

		} else if (appConfig.getProperty(Constants.APPLICATION_NAME).equals(Constants.ILMSDEVQADEFAULT)) {
			driver.get(appConfig.getProperty(Constants.ILMSDEVQADEFAULT_URL));

		} else if (appConfig.getProperty(Constants.APPLICATION_NAME).equals(Constants.ILMSDEVQACUSTOM)) {
			driver.get(appConfig.getProperty(Constants.ILMSDEVQACUSTOM_URL));

		} else if (appConfig.getProperty(Constants.APPLICATION_NAME).equals(Constants.STAGINGMSA)) {
			driver.get(appConfig.getProperty(Constants.STAGINGMSA_URL));

		} else if (appConfig.getProperty(Constants.APPLICATION_NAME).equals(Constants.STAGINGDEFAULT)) {
			driver.get(appConfig.getProperty(Constants.STAGINGDEFAULT_URL));

		} else if (appConfig.getProperty(Constants.APPLICATION_NAME).equals(Constants.STAGINGCUSTOM)) {
			driver.get(appConfig.getProperty(Constants.STAGINGCUSTOM_URL));

		}
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();

		extent.addSystemInfo("Browser Name",caps.getBrowserName().toUpperCase());
		extent.addSystemInfo("Browser Version",  caps.getVersion().toUpperCase());

	}

	@AfterMethod
	
	
	public void getResult(ITestResult result) throws IelException {
		if (result.getStatus() == ITestResult.FAILURE) {
			 String screenshotPath = getScreenshot(result.getName());
			//test.log(LogStatus.FAIL, "Test failed");
			test.log(LogStatus.FAIL, result.getThrowable());
			test.log(LogStatus.FAIL, test.addScreenCapture("." + screenshotPath));

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, "Test Passed");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Skipped");
		}
		extent.endTest(test);
		extent.flush();

		driver.quit();
	}

	/**
	 * @throws IelException
	 * 
	 */
	public void loadAppProperties() throws IelException {

		try {
			fis = new FileInputStream(Constants.APPCONFIG_FILE_PATH);
			appConfig.load(fis);

		} catch (IOException e) {
			throw new IelException(LOADPROPERTIES_ERROR + e.getMessage());
		}
	}

	/**
	 * This method is used to create screenshot
	 * 
	 * @param screenshotName
	 * @return
	 * @throws IelException
	 */
	public String getScreenshot(String screenshotName) throws IelException {

		try {
			String dateValue = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destination = ".\\" + SCREENSHOT_FOLDER_NAME
					+ Constants.FILE_SEPARATOR + screenshotName + PATH_SEPARATOR + dateValue + SCREENSHOT_FILETYPE;

			System.out.println("dest : " + destination);
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		} catch (IOException e) {
			throw new IelException(ERROR_SCREENSHOT + e.getMessage());
		}
	}

	@AfterSuite
	void tearDown() {

		extent.close();
	}

}
