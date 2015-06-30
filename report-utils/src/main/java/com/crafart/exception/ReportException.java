/**
 * 
 */
package com.crafart.exception;

/**
 * {@link ReportException} thrown while generation crafart reports. Exception of
 * type {@link ReportException} need to be handled appropriately in case of any
 * failures during report generation
 * 
 * @author Karthi
 *
 */
public class ReportException extends Exception {

	private static final long serialVersionUID = -1648571453852649152L;

	/**
	 * error message describes the why the exception been thrown along with stacktrace of the exception. 
	 * @param message
	 * @param throwable
	 */
	public ReportException(String message, Throwable throwable) {
		super(message, throwable);
	}

	/**
	 * error message describes the why the exception been thrown,this method not takes throwable. Use only message is required
	 * and no exception stacktrace needed.
	 * @param message
	 */
	public ReportException(String message) {
		super(message);
	}

}
