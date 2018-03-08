package com.iel.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.iel.automation.constants.Constants;
import com.iel.automation.library.PageBase;
import com.iel.automation.utilities.IelException;
import com.relevantcodes.extentreports.LogStatus;

public class OrganizationsPage extends PageBase {

	final static Logger logger = LoggerFactory.getLogger(OrganizationsPage.class);

	public OrganizationsPage() throws IelException {
		super();
	}

	@FindBy(xpath = "(//*[@title='Edit'])[1]")

	WebElement LinkEditOrg;

	@FindBy(xpath = "(//*[@title='Delete'])[1]")

	WebElement LinkDeleteOrg;

	@FindBy(xpath = "//*[text()='Organizations']")
	WebElement MenuOrganizations;

	@FindBy(xpath = "(//*[text()='Organizations'])[2]")
	WebElement LinkOrganizations;

	@FindBy(xpath = "//*[@id='contnetframe']")
	WebElement FrameContent;

	@FindBy(xpath = "//a[contains(@href, 'Organization.aspx')]")
	WebElement LinkAddOrg;

	@FindBy(id = "txtCustname")
	WebElement TextboxOrgName;

	@FindBy(id = "txtCustURL")
	WebElement TextboxCustomURL;

	@FindBy(id = "txtFirstName")
	WebElement TextboxFirstName;

	@FindBy(id = "txtLastName")
	WebElement TextboxLastName;

	@FindBy(id = "txtEmail")
	WebElement textboxEmailID;

	@FindBy(id = "txtPassword")
	WebElement TextboxPassword;

	@FindBy(id = "rdoICEnable")
	WebElement rdbtnIComposer;

	@FindBy(id = "rdInstructorCourseEnable")
	WebElement rdbtnInstructorCourses;

	@FindBy(id = "btnSubmit_btn")
	WebElement btnSave;

	@FindBy(xpath = "//*[contains(text(),'The value entered already exists in the system')]")
	WebElement textOrgIsAlredayExist;

	@FindBy(id = "ctlCustomerSearch_txtSearchString")
	WebElement textboxSearch;

	@FindBy(xpath = "//*[@id='srch_submit2']")
	WebElement clickSearch;

	@FindBy(xpath = "//img[@title='Edit']")
	WebElement iconEditOrg;

	public OrganizationsPage hoveringOrganizationsMenu() throws Exception {
		hoverOverElement(MenuOrganizations);
		return this;

	}

	public OrganizationsPage clickOnOrganiazationsLink() throws Exception {
		LinkOrganizations.click();
		test.log(LogStatus.PASS, "Clicked on organization link");
		logger.info("Clicked on organization link");

		return this;

	}

	public OrganizationsPage clickOnAddOrgLink() throws Exception {
		switchToFrameByWebElement(FrameContent);
		waitForElement(LinkAddOrg);
		LinkAddOrg.click();
		test.log(LogStatus.PASS, "Clicked on Add organization link");
		logger.info("Clicked on Add organization link");

		return this;

	}

	public OrganizationsPage enterOrgName() throws Exception {
		waitForElement(TextboxOrgName);
		TextboxOrgName.sendKeys(testData.get(Constants.ORGNIZATION_SHEET).get("OrganizationName"));
		test.log(LogStatus.PASS, "Entered Organization Name");
		logger.info("Entered Organization Name");

		return this;

	}

	public OrganizationsPage enterCustomURL() throws Exception {
		waitForElement(TextboxCustomURL);
		TextboxCustomURL.sendKeys(testData.get(Constants.ORGNIZATION_SHEET).get("CustomUrl"));
		test.log(LogStatus.PASS, "Entered Organization custom Url ");
		logger.info("Entered Organization custom Url ");

		return this;

	}

	public OrganizationsPage enterFirstName() throws Exception {
		TextboxFirstName.sendKeys(testData.get(Constants.ORGNIZATION_SHEET).get("FirstName"));
		test.log(LogStatus.PASS, "Entered first name ");
		logger.info("Entered first name ");

		return this;

	}

	public OrganizationsPage enterLastName() throws Exception {
		TextboxLastName.sendKeys(testData.get(Constants.ORGNIZATION_SHEET).get("LastName"));
		test.log(LogStatus.PASS, "Entered Last name ");
		logger.info("Entered Last name ");

		return this;

	}

	public OrganizationsPage enterEmailID() throws Exception {
		textboxEmailID.sendKeys(testData.get(Constants.ORGNIZATION_SHEET).get("EmailId"));
		test.log(LogStatus.PASS, "Entered Email ID ");
		logger.info("Entered Email ID ");

		return this;

	}

	public OrganizationsPage enterPassword() throws Exception {
		TextboxPassword.sendKeys(testData.get(Constants.ORGNIZATION_SHEET).get("Password"));
		test.log(LogStatus.PASS, "Entered Default Password");
		logger.info("Entered Default Password");

		return this;

	}

	public OrganizationsPage selectiComposer() throws Exception {
		rdbtnIComposer.click();
		test.log(LogStatus.PASS, "Selected IComposer ");
		logger.info("Selected IComposer ");

		return this;

	}

	public OrganizationsPage selectInstructor() throws Exception {
		rdbtnInstructorCourses.click();
		test.log(LogStatus.PASS, "Selected IConstructor");
		logger.info("Selected IConstructor");

		return this;

	}

	public OrganizationsPage clickSavebutton() throws Exception {
		btnSave.click();
		test.log(LogStatus.PASS, "Clicked on Save button");
		logger.info("Clicked on Save button");

		return this;

	}

	public OrganizationsPage verifyOrgCreation() throws InterruptedException {
		Assert.assertEquals(getTheTextAndAcceptTheAlert(), "Organization details saved successfully.");
		Thread.sleep(10000);
		test.log(LogStatus.PASS, "Verified Organization details saved successfully.");

		logger.info("Verified Organization details saved successfully.");

		return this;

	}

	public OrganizationsPage verifyIsOrgExisting() {

		Assert.assertEquals(textOrgIsAlredayExist.getText(), "The value entered already exists in the system");
		return this;

	}

	public OrganizationsPage enterTextAndSearch() {
		switchToFrameByWebElement(FrameContent);
		textboxSearch.sendKeys("Cs13");
		clickSearch.click();
		return this;

	}

	public OrganizationsPage clickEditOrgIcon() {
		iconEditOrg.click();
		return this;

	}

}
