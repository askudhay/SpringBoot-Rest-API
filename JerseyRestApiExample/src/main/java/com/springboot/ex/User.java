package com.springboot.ex;

/**
 * Model domain class
 * 
 * @author Udhay
 *
 */
public class User {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [" + id + " ; " + username + "]";
	}

	int id;
	String username;
}
