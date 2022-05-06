package com.revature.ProTwo.exceptions;

public class CommentNotFoundException extends Exception {
	private static final long serialVersionUID = -485086060844157709L;

	public CommentNotFoundException() {
		super("Comment not Found");
	}
}

