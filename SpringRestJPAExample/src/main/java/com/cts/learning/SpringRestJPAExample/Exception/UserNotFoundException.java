package com.cts.learning.SpringRestJPAExample.Exception;

/**
 * Custom Exception Class
 * 
 * @author Udhay
 *
 */
@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
