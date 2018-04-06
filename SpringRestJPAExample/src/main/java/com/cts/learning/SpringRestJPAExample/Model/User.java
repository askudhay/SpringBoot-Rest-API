package com.cts.learning.SpringRestJPAExample.Model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Model Entity Class
 * 
 * @author Udhay
 *
 */
@Entity
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long rowID; 
	
	@ApiModelProperty(notes="User ID")
	long userID;
	String userName;
}
