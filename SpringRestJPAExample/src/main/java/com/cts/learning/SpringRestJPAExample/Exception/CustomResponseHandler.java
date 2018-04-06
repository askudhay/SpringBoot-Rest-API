package com.cts.learning.SpringRestJPAExample.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 * Custom Response Handler class to handle
 * exceptions
 * 
 * @author Udhay
 *
 */
@ControllerAdvice
public class CustomResponseHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * Method to handle generic exception; Returns Status code '500' 
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
		ExceptionResponse exResp = new ExceptionResponse(new Date(), "Generic Exception", "Something broken at server side, please email us", request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exResp,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Method to handle user not found exception; Returns Status code '404' 
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleUserNotFoundEx(Exception ex, WebRequest request){
		ExceptionResponse exResp = new ExceptionResponse(new Date(), "User Not Found", ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exResp,HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Method to handle No user exists exception; Returns Status code '204' 
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(NoUserFoundException.class)
	public final ResponseEntity<Object> handleNoUserFoundEx(Exception ex, WebRequest request){
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Method to handle User already exists exception; Returns Status code '409' 
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(UserAlreadyExists.class)
	public final ResponseEntity<ExceptionResponse> handleUserAlreadyExists(Exception ex, WebRequest request){
		ExceptionResponse exResp = new ExceptionResponse(new Date(), "User Already Exists", ex.getMessage() + ". You can't save same User details more than once. Try PUT instead if you wanna update.", request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exResp,HttpStatus.CONFLICT);
	}
}
