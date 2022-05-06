package com.revature.ProTwo.services;

import java.util.Set;

import com.revature.ProTwo.beans.User;
import com.revature.ProTwo.beans.Review;

import com.revature.ProTwo.beans.UserComment;
import com.revature.ProTwo.exceptions.CommentNotFoundException;

public interface CommentService {
	public UserComment create(UserComment userCmm) throws CommentNotFoundException;
	public UserComment delete(UserComment userCmm);
	public UserComment getCommentById(int commentId);
	public Set<UserComment> viewAllCommentsByUser(User user);
	public Set<UserComment> viewAllCommentsByReview(Review review);
}
