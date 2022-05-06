package com.revature.ProTwo.services;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.ProTwo.beans.Review;
import com.revature.ProTwo.beans.User;
import com.revature.ProTwo.beans.UserComment;
import com.revature.ProTwo.data.UserCommentRepository;
import com.revature.ProTwo.data.UserRepository;
import com.revature.ProTwo.exceptions.CommentNotFoundException;
import com.revature.ProTwo.exceptions.ReviewNotFoundException;
import com.revature.ProTwo.exceptions.UsernameAlreadyExistsException;

@Service
public class CommentServiceImpl implements CommentService{

	private UserCommentRepository cmmtRepo;
	// constructor injection
	@Autowired
	public CommentServiceImpl(UserCommentRepository cmmtRepo) {
		this.cmmtRepo = cmmtRepo;
	}

	@Override
	public UserComment create(UserComment userCmm) throws CommentNotFoundException {
		
		userCmm.setSentAt(LocalDateTime.now());
		int newCmm = cmmtRepo.save(userCmm).getId();
		if (newCmm > 0) {
			userCmm.setId(newCmm);
			return userCmm;
		} else if (newCmm == -1) {
			throw new CommentNotFoundException();
		}
		return null;
	}
	
	@Override
	public Set<UserComment> viewAllCommentsByUser(User user){
		return cmmtRepo.findAllByUserId(user.getId());
	}
	
	@Override
	public UserComment delete(UserComment userCmm) {
		cmmtRepo.delete(userCmm);
		return userCmm;
	}

	public UserComment getCommentById(int comment_id) {
		return cmmtRepo.findById(comment_id).get();
	}
	@Override
	public Set<UserComment> viewAllCommentsByReview(Review review) {
		return cmmtRepo.findAllByReviewId(review.getId());
	}
}
