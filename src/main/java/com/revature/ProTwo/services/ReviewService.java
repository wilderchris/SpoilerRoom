package com.revature.ProTwo.services;

import java.util.Set;

import com.revature.ProTwo.beans.Movie;
import com.revature.ProTwo.beans.MovieRating;
import com.revature.ProTwo.beans.Review;
import com.revature.ProTwo.beans.ReviewLikes;
import com.revature.ProTwo.beans.UserComment;

public interface ReviewService {
	public Review postNewReview(Review newReview);
	public void likeReview(ReviewLikes newLike);
	public Review getReviewById(int review_id);
	public Set<UserComment> getAllCommentsForReview(int reviewId);
}
