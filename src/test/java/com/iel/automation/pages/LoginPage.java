package com.iel.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iel.automation.constants.Constants;
import com.iel.automation.library.PageBase;
import com.iel.automation.utilities.IelException;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage extends PageBase {

	final static Logger logger = LoggerFactory.getLogger(LoginPage.class);

	public LoginPage() throws IelException {
		super();
	}

	@FindBy(xpath = "//*[@id='txtUsername']")

	WebElement TextBoxUserName;

	@FindBy(id = "txtPassword")

	WebElement TextBoxPassword;

	@FindBy(xpath = "//*[contains(@id,'btnLogin')]")
	WebElement ButtonLogin;

	/**
	 * Reusbale method to be used for login in application for all other test
	 * scripts
	 * 
	 * @param strUserName
	 * @param strPassword
	 * @throws IelException
	 * 
	 */
	public void loginToApplication(String strUserName, String strPassword) throws IelException {
		enterUserName(strUserName);
		enterPassword(strPassword);
		clickLoginBtn();
	}

	public void enterUserName(String strUserName) throws IelException {
		enterText(TextBoxUserName, strUserName);
		test.log(LogStatus.PASS, "Entered UserName");
		logger.info("Entered UserName");
	}

	public void enterPassword(String strPassword) throws IelException {
		enterText(TextBoxPassword, strPassword);
		test.log(LogStatus.PASS, "Entered Password");
		logger.info("Entered Password");

	}

	public void clickLoginBtn() {
		ButtonLogin.click();
		test.log(LogStatus.PASS, "Clicked on login button");
		logger.info("Clicked on login button");

	}
}