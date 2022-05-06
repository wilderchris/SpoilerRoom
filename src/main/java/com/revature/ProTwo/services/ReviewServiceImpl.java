package com.revature.ProTwo.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.ProTwo.beans.Movie;
import com.revature.ProTwo.beans.MovieRating;
import com.revature.ProTwo.beans.Review;
import com.revature.ProTwo.beans.ReviewLikes;
import com.revature.ProTwo.beans.ReviewLikesId;
import com.revature.ProTwo.beans.UserComment;
import com.revature.ProTwo.data.MovieRatingRepository;
import com.revature.ProTwo.data.ReviewLikesRepository;
import com.revature.ProTwo.data.ReviewRepository;
import com.revature.ProTwo.data.UserCommentRepository;
import com.revature.ProTwo.data.UserRepository;
import com.revature.ProTwo.exceptions.UsernameAlreadyExistsException;

@Service
public class ReviewServiceImpl implements ReviewService {
	private ReviewRepository revRepo;
	private UserCommentRepository cmmtRepo;
	private ReviewLikesRepository likesRepo;

	// constructor injection
	@Autowired
	public ReviewServiceImpl(ReviewRepository revRepo,
							 ReviewLikesRepository likesRepo, 
							 UserCommentRepository cmmtRepo) {
		this.revRepo = revRepo;
		this.cmmtRepo = cmmtRepo;
		this.likesRepo = likesRepo;
	}

	@Override
	public Review postNewReview(Review newReview) {
		int newId = revRepo.save(newReview).getId();
		newReview.setId(newId);
		return newReview;
	}

	@Override
	public void likeReview(ReviewLikes newLike) {
		likesRepo.save(newLike);
	}
	
	@Override
	public Review getReviewById(int review_id) {
		return revRepo.findById(review_id).get();
	}
	
	@Override
	public Set<UserComment> getAllCommentsForReview(int reviewId){
		return cmmtRepo.findByReviewOrderBySentAtDesc(revRepo.findById(reviewId).get());
	}
}
