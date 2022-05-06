package com.revature.ProTwo.beans;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
//For IdClass method
//import javax.persistence.Id;
//import javax.persistence.IdClass;

//For IdClass method
//@IdClass(ReviewLikesId.class)
@Entity
public class ReviewLikes {


	//For IdClass method
	//@Id
	//private User user;
	//@Id
	//private Review review;
	@EmbeddedId
	private ReviewLikesId reviewLikesId;	
	
	private boolean liked;
	
	public ReviewLikes() {super();}

	public ReviewLikes(ReviewLikesId reviewLikesId, boolean liked) {
		super();
		this.reviewLikesId = reviewLikesId;
		this.liked = liked;
	}

	public ReviewLikesId getReviewLikesId() {
		return reviewLikesId;
	}

	public void setReviewLikesId(ReviewLikesId reviewLikesId) {
		this.reviewLikesId = reviewLikesId;
	}
	public void setReviewLikesId(Long userId, Long reviewId) {
		ReviewLikesId nl = new ReviewLikesId();
		nl.setUserId(userId);
		nl.setReviewId(reviewId);
	}

	public boolean getLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(liked, reviewLikesId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewLikes other = (ReviewLikes) obj;
		return liked == other.liked && Objects.equals(reviewLikesId, other.reviewLikesId);
	}

	@Override
	public String toString() {
		return "ReviewLikes [reviewLikesId=" + reviewLikesId + ", liked=" + liked + "]";
	}
	
	

}
