package com.revature.ProTwo.exceptions;

public class UsernameAlreadyExistsException extends Exception {
	private static final long serialVersionUID = -8967330998704030874L;

	public UsernameAlreadyExistsException() {
		super("The chosen username is taken by another user.");
	}
}
