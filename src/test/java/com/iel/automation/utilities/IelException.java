package com.iel.automation.utilities;

public class IelException extends Exception {

	/** 
	 * This class is used to create customized exception
	 * @author Chandrashekhar.Reddy
	 * @since 27 Feb 2018
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IelException(String strMessage) {
		super(strMessage);
	}

}