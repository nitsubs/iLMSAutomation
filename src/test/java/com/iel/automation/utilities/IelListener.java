package com.iel.automation.utilities;

import org.testng.IInvokedMethod;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.iel.automation.library.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class IelListener extends TestBase implements ITestListener {

	// This belongs to ISuiteListener and will execute before the Suite start

	public IelListener() throws IelException {

		super();

	}

	// This belongs to ITestListener and will execute before starting of Test
	// set/batch

	public void onStart(ITestContext arg0) {

		// Reporter.log("About to begin executing Test " + arg0.getName(),
		// true);
		test.log(LogStatus.INFO, "About to begin executing Test " + arg0.getName());

	}

	// This belongs to ITestListener and will execute, once the Test set/batch
	// is finished

	public void onFinish(ITestContext arg0) {

		// Reporter.log("Completed executing test " + arg0.getName(), true);
		test.log(LogStatus.INFO, "Completed executing test " + arg0.getName());
	}

	// This belongs to ITestListener and will execute only when the test is pass

	public void onTestSuccess(ITestResult arg0) {

		// This is calling the printTestResults method

		printTestResults(arg0);

	}

	// This belongs to ITestListener and will execute only on the event of fail
	// test

	public void onTestFailure(ITestResult arg0) {

		// This is calling the printTestResults method

		printTestResults(arg0);

	}

	// This belongs to ITestListener and will execute before the main test start
	// (@Test)

	public void onTestStart(ITestResult arg0) {

		// System.out.println("The execution of the main test starts now");
		test.log(LogStatus.INFO, "The execution of the main test starts now");

	}

	// This belongs to ITestListener and will execute only if any of the main
	// test(@Test) get skipped

	public void onTestSkipped(ITestResult arg0) {

		printTestResults(arg0);

	}

	// This will provide the information on the test

	private void printTestResults(ITestResult result) {

		// Reporter.log("Test Method resides in " +
		// result.getTestClass().getName(), true);
		test.log(LogStatus.INFO, "Test Method resides in " + result.getTestClass().getName());

		if (result.getParameters().length != 0) {

			String params = null;

			for (Object parameter : result.getParameters()) {

				params += parameter.toString() + ",";

			}
			test.log(LogStatus.INFO, "Test Method had the following parameters : " + params);
			// Reporter.log("Test Method had the following parameters : " +
			// params, true);

		}

		String status = null;

		switch (result.getStatus()) {

		case ITestResult.SUCCESS:

			status = "Pass";
			test.log(LogStatus.PASS, "Test Status: " + status);

			break;

		case ITestResult.FAILURE:

			status = "Failed";
			test.log(LogStatus.FAIL, "Test Status: " + status);

			break;

		case ITestResult.SKIP:

			status = "Skipped";
			test.log(LogStatus.SKIP, "Test Status: " + status);

		}

		// Reporter.log("Test Status: " + status, true);

	}

	// This belongs to IInvokedMethodListener and will execute before every
	// method including @Before @After @Test

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "About to begin executing following method : " + returnMethodName(arg0.getTestMethod());

		// Reporter.log(textMsg, true);
		test.log(LogStatus.INFO, textMsg);

	}

	// This belongs to IInvokedMethodListener and will execute after every
	// method including @Before @After @Test

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "Completed executing following method : " + returnMethodName(arg0.getTestMethod());

		// Reporter.log(textMsg, true);
		test.log(LogStatus.INFO, textMsg);

	}

	// This will return method names to the calling function

	private String returnMethodName(ITestNGMethod method) {

		return method.getRealClass().getSimpleName() + "." + method.getMethodName();

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

}