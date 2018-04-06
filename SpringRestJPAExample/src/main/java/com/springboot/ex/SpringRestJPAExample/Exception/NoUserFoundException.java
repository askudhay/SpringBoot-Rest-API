package com.springboot.ex.SpringRestJPAExample.Exception;

/**
 * Custom Exception class
 * 
 * @author Udhay
 *
 */
@SuppressWarnings("serial")
public class NoUserFoundException extends RuntimeException {

	public NoUserFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
