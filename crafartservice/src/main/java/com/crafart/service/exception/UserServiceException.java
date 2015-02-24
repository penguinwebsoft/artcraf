/**
 * 
 */
package com.crafart.service.exception;

/**
 * @author Karthi
 * @version 1.0
 *
 */
public class UserServiceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7082264604097600338L;
	
	public UserServiceException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public UserServiceException(String message){
		super(message);
	}
}
