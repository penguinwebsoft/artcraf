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
	private static final long serialVersionUID = -7082264604097600338L;
	
	public CrafartServiceException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public CrafartServiceException(String message){
		super(message);
	}
}
