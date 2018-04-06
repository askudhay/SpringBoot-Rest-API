package com.springboot.ex.SpringRestJPAExample.Exception;

import java.util.Date;

/**
 * Custom Exception Response Model Class
 * 
 * @author Udhay
 *
 */
public class ExceptionResponse {
	
	private Date dateObj;
	private String errMsg;
	private String errDesc;
	private String webRequest;

	public Date getDateObj() {
		return dateObj;
	}

	public void setDateObj(Date dateObj) {
		this.dateObj = dateObj;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrDesc() {
		return errDesc;
	}

	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}

	public ExceptionResponse(Date dateObj, String errMsg, String errDesc,
			String webRequest) {
		super();
		this.dateObj = dateObj;
		this.errMsg = errMsg;
		this.errDesc = errDesc;
		this.webRequest = webRequest;
	}

	public String getWebRequest() {
		return webRequest;
	}

	public void setWebRequest(String webRequest) {
		this.webRequest = webRequest;
	}

}
