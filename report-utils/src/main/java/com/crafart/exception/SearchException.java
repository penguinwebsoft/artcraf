package com.crafart.exception;


/**
 * exception thrown when any search errors occured, it extends {@link Exception} , so enforcing calling method
 * to handle and do appropriate actions when any search error.
 * @author p.periyasamy
 *
 */
public class SearchException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5014958940601045698L;
	
	/**
	 * error message describes the why the exception been thrown along with stacktrace of the exception. 
	 * @param message
	 * @param throwable
	 */
	public SearchException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	/**
	 * error message describes the why the exception been thrown,this method not takes throwable. Use only message is required
	 * and no exception stacktrace needed.
	 * @param message
	 */
	public SearchException(Throwable throwable){
		super(throwable);
	}

}
