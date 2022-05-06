package com.revature.ProTwo.exceptions;

public class IncorrectCredentialsException extends Exception {
	private static final long serialVersionUID = -485086060844157709L;

	public IncorrectCredentialsException() {
		super("Username or password was incorrect.");
	}
}
