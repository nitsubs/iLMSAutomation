package com.iel.automation.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.iel.automation.constants.Constants;
import com.iel.automation.library.TestBase;
import com.relevantcodes.extentreports.LogStatus;


/**
 * This class is for the purpose to implement retry capability for the fail test
 * 
 * @author vikas.verma
 * @since 20 Feb 2018
 *
 */

public class Retry extends TestBase implements IRetryAnalyzer {

	final static Logger logger = LoggerFactory.getLogger(Retry.class);
	
		
	 public Retry() throws IelException {
		 
			super();

		}
	 
	 /**
		 * This method is used to retry the number of attempts 
		 * 
		 * @author Vikas.Verma
		 * @since 20 Feb 2018
		 * @param result
		 */
	 
	 
	 
	@Override
	public boolean retry(ITestResult result) {
		int retrycount = 0;
		
		if (retrycount<Integer.parseInt(appConfig.getProperty(Constants.MAXRETRY_COUNT))){
			
			test.log(LogStatus.PASS, "Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retrycount+1) + " time(s).");
			
			logger.info("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retrycount+1) + " time(s).");
			
			System.out.println("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retrycount+1) + " time(s).");
		
			retrycount++;
            return true;
		}
		
		return false;
	}

	 /**
		 * This method is used to get the test status  
		 * 
		 * @author Vikas.Verma
		 * @since 20 Feb 2018
		 * @param status
		 */
	
	 public String getResultStatusName(int status) {
	    	String resultName = null;
	    	if(status==1)
	    		resultName = "SUCCESS";
	    	if(status==2)
	    		resultName = "FAILURE";
	    	if(status==3)
	    		resultName = "SKIP";
			return resultName;
	    }
}
