package com.revature.ProTwo.exceptions;

public class MovieAlreadyExistsException extends Exception {

	private static final long serialVersionUID = -6060806794395918956L;
	public MovieAlreadyExistsException() {
		super("Movie already exists, can't create.");
	}
}
