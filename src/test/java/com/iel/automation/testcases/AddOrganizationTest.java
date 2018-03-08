package com.iel.automation.testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.iel.automation.constants.Constants;
import com.iel.automation.library.TestBase;
import com.iel.automation.pages.LoginPage;
import com.iel.automation.pages.OrganizationsPage;
import com.iel.automation.utilities.IelException;

public class AddOrganizationTest extends TestBase {

	final static Logger logger = LoggerFactory.getLogger(AddOrganizationTest.class);

	LoginPage login;
	OrganizationsPage org;

	public AddOrganizationTest() throws IelException {
		super();

	}

	@Test(description = "verifyAddOrganization")
	public void verifyAddOrganization() throws Exception {
		login = new LoginPage();
		org = new OrganizationsPage();

		login.loginToApplication(testData.get(Constants.LOGINPAGE_SHEET).get("userName"),testData.get(Constants.LOGINPAGE_SHEET).get("password"));

		org.hoveringOrganizationsMenu().clickOnOrganiazationsLink().clickOnAddOrgLink().enterOrgName().enterCustomURL()
				.enterFirstName().enterLastName().enterEmailID().enterPassword().selectiComposer().selectInstructor()
				.clickSavebutton().verifyOrgCreation();
		logger.info("Test executed successfully");

	}

}
