package com.revature.ProTwo.exceptions;

public class UserNotFoundException extends Exception {
	
	private static final long serialVersionUID = -6060806794395918956L;
	public UserNotFoundException() {
		super("User not found in database.");
	}

}
