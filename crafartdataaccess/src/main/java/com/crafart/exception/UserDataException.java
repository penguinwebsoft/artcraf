/**
 * 
 */
package com.crafart.exception;

/**
 * @author Karthi
 *
 */
public class UserDataException extends Exception {

	private static final String ERROR = "Database Transaction Error: ";
	/**
	 * 
	 */
	private static final long serialVersionUID = -1648571453852649152L;
	
	public UserDataException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public UserDataException(String message) {
		super(message);
	}


}
