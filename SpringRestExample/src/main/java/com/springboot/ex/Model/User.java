package com.springboot.ex.Model;
/**
 * Model Class
 * 
 * @author Udhay
 *
 */
public class User {
	
	public User(){ 
	}
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	long userID;
	String userName;
}
