package com.iel.automation.testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.iel.automation.constants.Constants;
import com.iel.automation.library.TestBase;
import com.iel.automation.pages.HomePage;
import com.iel.automation.pages.LoginPage;
import com.iel.automation.utilities.IelException;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends TestBase {

	final static Logger logger = LoggerFactory.getLogger(LoginTest.class);
	LoginPage login;
	HomePage home;
	public LoginTest() throws IelException {
		super();
	}




	@Test(description = "Verify Login for Valid Credentials" , priority=1)
	public void verifyLogin() throws Exception {
		 login = new LoginPage();

		test.log(LogStatus.INFO, "Test execution started");
		logger.info("Test execution started");
		login.loginToApplication(testData.get(Constants.LOGINPAGE_SHEET).get("userName"),testData.get(Constants.LOGINPAGE_SHEET).get("password"));
		logger.info("Test executed successfully");

	}

	@Test(description = "Verify Login for InValid Credentials" , priority=2)
	public void verifyInvalidLogin() throws Exception {
		login = new LoginPage();
		home = new HomePage();
		test.log(LogStatus.INFO, "Test execution started");
		logger.info("Test execution started");
		login.loginToApplication(testData.get(Constants.LOGINPAGE_SHEET).get("userName"),testData.get(Constants.LOGINPAGE_SHEET).get("invalidPassword"));
		
		home.verfiyLogin();
	}

}
