package com.revature.ProTwo.exceptions;

public class ReviewNotFoundException extends Exception {
	private static final long serialVersionUID = -485086060844157709L;
	
	public ReviewNotFoundException() {
		super("Review not Found");
	}
}
