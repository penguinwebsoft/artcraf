/**
 * 
 */
package com.crafart.exception;

/**
 * @author Karthi
 *
 */
public class CrafartDataException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1648571453852649152L;
	
	public CrafartDataException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public CrafartDataException(String message) {
		super(message);
	}


}
