package com.springboot.ex.util;
/**
 * Custom Error Class
 * 
 * @author Udhay
 *
 */
public class CustomError {
	public CustomError(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	String errorMsg;
}
