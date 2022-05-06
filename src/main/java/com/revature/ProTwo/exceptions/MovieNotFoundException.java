package com.revature.ProTwo.exceptions;

public class MovieNotFoundException extends Exception {

	private static final long serialVersionUID = -6060806794395918956L;
	public MovieNotFoundException() {
		super("Movie not found in database.");
	}
}
