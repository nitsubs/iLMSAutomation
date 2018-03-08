package com.iel.automation.pages.courses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.iel.automation.constants.Constants;
import com.iel.automation.library.PageBase;
import com.iel.automation.utilities.IelException;
import com.relevantcodes.extentreports.LogStatus;

public class LearningPathPage extends PageBase {

	final static Logger logger = LoggerFactory.getLogger(LearningPathPage.class);

	public LearningPathPage() throws IelException {
		super();
	}

	@FindBy(xpath = "//*[text()='Courses']")
	WebElement menuCourses;

	@FindBy(xpath = "//*[text()='Learning Path']")
	WebElement LinkLearningPath;

	@FindBy(xpath = "//*[@id='addLearningPath']")
	WebElement LinkAddLarningPath;

	@FindBy(id = "lpName")
	WebElement textboxLPName;

	@FindBy(id = "saveNewLP")
	WebElement btnLPSave;

	@FindBy(xpath = "//*[@id='contnetframe']")
	WebElement frameContent;

	@FindBy(id = "lblSuccessMsg")
	WebElement txtSucessMsg; 
	
	@FindBy(xpath = "(//*[@class='k-icon k-edit'])[1]")
	WebElement iconEdit;
	
	
	@FindBy(id = "lblLpName")
	WebElement txtLPName;


	public LearningPathPage hoveronCoursesMenu() throws Exception {
		hoverOverElement(menuCourses);
		test.log(LogStatus.PASS, "Mouse hover on Courses menu");
		logger.info("Mouse hover on Courses menu");
		Thread.sleep(2000);
		return this;

	}

	public LearningPathPage clickOnLearningPathLink() throws Exception {
		LinkLearningPath.click();
		test.log(LogStatus.PASS, "Clicked on Learning Path link");
		logger.info("Clicked on Learning Path link");
		Thread.sleep(6000);
		return this;

	}

	public LearningPathPage clickOnAddLearningPathLink() throws Exception {
		switchToFrameByWebElement(frameContent);
		LinkAddLarningPath.click();
		test.log(LogStatus.PASS, "Clicked on Add Learning Path link");
		logger.info("Clicked on Add Learning Path link");
		return this;

	}

	public LearningPathPage enterLPName() throws Exception {
		textboxLPName.sendKeys(testData.get(Constants.LEARNINGPATH_SHEET).get("learningpathname"));
		test.log(LogStatus.PASS, "Enter the Learning Path name");
		logger.info("Enter the Learning Path name");
		return this;

	}

	public LearningPathPage clickLPSaveButton() throws Exception {
		btnLPSave.click();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Clicked on Save button");
		logger.info("Clicked on Save button");
		return this;

	}

	public LearningPathPage verifyLearningPathCreation() throws Exception {	
		Assert.assertTrue(txtSucessMsg.isDisplayed());

		test.log(LogStatus.PASS, "Learning Path " + testData.get(Constants.LEARNINGPATH_SHEET).get("learningpathname")
				+ " added successfully.");

		logger.info("Learning Path " + testData.get(Constants.LEARNINGPATH_SHEET).get("learningpathname")
				+ "  added successfully.");

		return this;
	}

}
