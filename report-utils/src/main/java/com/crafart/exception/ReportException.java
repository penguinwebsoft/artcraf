/**
 * 
 */
package com.crafart.exception;

/**
 * @author Karthi
 *
 */
public class ReportException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1648571453852649152L;
	
	public ReportException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ReportException(String message) {
		super(message);
	}


}
