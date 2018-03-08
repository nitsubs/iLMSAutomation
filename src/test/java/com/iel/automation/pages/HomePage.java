package com.iel.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.iel.automation.library.PageBase;
import com.iel.automation.utilities.IelException;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends PageBase {

	final static Logger logger = LoggerFactory.getLogger(HomePage.class);

	public HomePage() throws IelException {
		super();
	}

	@FindBy(xpath = "//*[@id='ImgLogoPath']")

	WebElement ImageHomePageLogo;

	@FindBy(xpath = "//*[@id='SwitchRoleMenuPanel']/ul/li/a/span")

	WebElement TextMasterSuperAdmin;

	@FindBy(xpath = "//*[text()='Help']")

	WebElement LinkHelp;

	@FindBy(xpath = "//*[@id='lblActiveCourses']/a")

	WebElement LinkActiveCourses;

	@FindBy(xpath = "//input[@name='radNumberOfRecords2']")

	WebElement TextBoxDisplay;

	@FindBy(xpath = "(//*[text()='Organizations'])[1]")

	WebElement LinkHomePageOrganization;

	@FindBy(xpath = "(//*[text()='Organizations'])[2]")

	WebElement LinkOrganization;

	@FindBy(xpath = "//*[@id='contnetframe']")

	WebElement FrameContent;

	@FindBy(xpath = "//*[contains(text(),'Logout')]")
	WebElement linkLogout;

	public void verfiyLogin() throws IelException {

		try {
			String url = driver.getCurrentUrl().trim();

			Assert.assertEquals(url, "http://staging.inspiredlms.com/user/master.aspx",
					"Username or Password is incorrect");

			test.log(LogStatus.PASS, "Login successfull");
			logger.info("Login successfull");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to login:Username or Password is incorrect");
			logger.info("Failed to logi: Username or Password is incorrectn");
			throw new IelException("Failed to login : Username or Password is incorrect");
		}

	}

	public void verfiyHomePage() throws IelException {

		try {
			String name = TextMasterSuperAdmin.getText().trim();
			Assert.assertEquals(name, "Master Super Admin");

			test.log(LogStatus.PASS, "verified home page successfully");
			logger.info("verified home page successfully");

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to verify home page");
			logger.info("Failed to verify home page");
			throw new IelException("Failed to verify home page");

		}
	}

	public void clickonHelpLinkandNavigateToNewWindow() throws Exception {
		LinkHelp.click();
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Thread.sleep(3000);
		driver.manage().window().maximize();
		scrollDownTillPageEnd();

	}

	public void clickonActiveCourses() throws Exception {
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		LinkActiveCourses.click();

	}

	public void clickLogout() {
		linkLogout.click();
	}
}
