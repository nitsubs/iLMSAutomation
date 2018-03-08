package com.iel.automation.utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;


/**
 * This class is for the custom listener for the fail test
 * 
 * @author vikas.verma
 * @since 20 Feb 2018
 *
 */

public class RetryListner implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation arg0, Class arg1, Constructor arg2,
			Method arg3) {
		// TODO Auto-generated method stub
		
		IRetryAnalyzer analyzer = arg0.getRetryAnalyzer();
		
		if (analyzer == null)	{
			arg0.setRetryAnalyzer(Retry.class);
		}

	}

}
