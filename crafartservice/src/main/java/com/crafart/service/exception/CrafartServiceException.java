/**
 * 
 */
package com.crafart.service.exception;

/**
 * @author Karthi
 * @version 1.0
 *
 */
public class CrafartServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6070120246127584816L;

	/**
	 * 
	 */
	
	public CrafartServiceException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public CrafartServiceException(String message){
		super(message);
	}
}
