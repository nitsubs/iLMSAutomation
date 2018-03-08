package com.iel.automation.constants;

public class Constants {

	public final static String BROWSER_NAME = "browser";
	public final static String IMPLICIT_WAIT = "implicit.wait";
	public final static String EXPLICIT_WAIT = "explicit.wait";

	public final static String FF_BROWSER = "firefox";
	public final static String IE_BROWSER = "IE";
	public final static String CHROME_BROWSER = "chrome";

	public static final String APPCONFIG_FILE_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Properties\\appConfig.properties";
	public static final String GECKODRIVER_EXE_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Drivers\\geckodriver.exe";
	public static final String IEDRIVER_EXE_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Drivers\\IEDriverServer.exe";
	public static final String CHROMEDRIVER_EXE_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Drivers\\chromedriver.exe";
	public static final String REPORTCONFIG_FILE_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\Properties\\extent-config.xml";
	public static final String TESTDATA_FILE_PATH = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\TestData\\testdata.xlsx";
	public static final String FF_SYSTEM_PROPERTY = "webdriver.gecko.driver";
	public static final String IE_SYSTEM_PROPERTY = "webdriver.ie.driver";
	public static final String CHROME_SYSTEM_PROPERTY = "webdriver.chrome.driver";

	public static final String EXTENT_OUTPUT_REPORT_PATH = System.getProperty("user.dir")
			+ "/test-output/ExtentReport.html";
	public static final String APPLICATION_URL = "testsiteurl";
	public static final String LOGINPAGE_SHEET = "Login";
	public static final String LEARNINGPATH_SHEET = "LearningPath";
	
	public static final String HOMEPAGE_SHEET = "HomePage";
	public static final String ORGNIZATION_SHEET = "Organization";
	public static final String FILE_SEPARATOR = "\\";
	
	public final static String APPLICATION_NAME = "application";

	public final static String ILMSDEVQAMSA = "ilmsdevqamsa";
	public final static String ILMSDEVQADEFAULT = "ilmsdevqadefault";
	public final static String ILMSDEVQACUSTOM = "ilmsdevqacustom";
	public final static String STAGINGMSA = "stagingmsa";
	public final static String STAGINGDEFAULT = "stagingdefault";
	public final static String STAGINGCUSTOM = "stagingcustom";

	public static final String ILMSDEVQAMSA_URL = "ilmsdevqamsaurl";
	public static final String ILMSDEVQADEFAULT_URL = "ilmsdevqadefaulturl";
	public static final String ILMSDEVQACUSTOM_URL = "ilmsdevqacustomturl";

	public static final String STAGINGMSA_URL = "stagingmsaurl";
	public static final String STAGINGDEFAULT_URL = "stagingdefaulturl";
	public static final String STAGINGCUSTOM_URL = "stagingcustomurl";
	public final static String MAXRETRY_COUNT = "maxretyrcount";

}
