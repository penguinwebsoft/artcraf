/**
 * 
 */
package com.crafart.exception;

/**
 * {@link ReportException} thrown while generation crafart reports.
 * Exception of type {@link ReportException} need to be handled appropriately in case of any failures during report generation
 * 
 * @author Karthi
 *
 */
public class ReportException extends Exception {

	
	private static final long serialVersionUID = -1648571453852649152L;
	
	public ReportException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ReportException(String message) {
		super(message);
	}


}
