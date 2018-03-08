package com.iel.automation.testcases.courses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.iel.automation.constants.Constants;
import com.iel.automation.library.TestBase;
import com.iel.automation.pages.LoginPage;
import com.iel.automation.pages.courses.LearningPathPage;
import com.iel.automation.utilities.IelException;

import net.sourceforge.htmlunit.corejs.javascript.ast.CatchClause;

/**
 * This class contains all Learning path related test cases
 * 
 * @author Chandrashekhar.Reddy
 *
 */
public class LearningPathTest extends TestBase {

	final static Logger logger = LoggerFactory.getLogger(LearningPathTest.class);

	LoginPage login;
	LearningPathPage path;

	public LearningPathTest() throws IelException {
		super();

	}/**
		 * This method will create Learning path and verify the success message
		 * 
		 * @throws Exception
		 * @author Chandrashekhar.Reddy
		 * @since 01 MAR 2018
		 */
	

	

	@Test(description = "verifyAddLearningPath")
	
	public void verifyAddLearningPath() throws Exception {

		login = new LoginPage();
		path = new LearningPathPage();

		login.loginToApplication(testData.get(Constants.LOGINPAGE_SHEET).get("orgusername"),
				testData.get(Constants.LOGINPAGE_SHEET).get("orgpassword"));
		Thread.sleep(6000);

		path.hoveronCoursesMenu().clickOnLearningPathLink().clickOnAddLearningPathLink().enterLPName()
				.clickLPSaveButton().verifyLearningPathCreation();

		logger.info("Test executed successfully");
	}


}


