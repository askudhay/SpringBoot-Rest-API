package com.cts.learning.SpringRestJPAExample.Exception;

/**
 * Custom Exception Class
 * 
 * @author Udhay
 *
 */
@SuppressWarnings("serial")
public class UserAlreadyExists extends RuntimeException {
	public UserAlreadyExists(String message) {
		super(message);
	}
}
