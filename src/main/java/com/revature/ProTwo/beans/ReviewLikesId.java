package com.revature.ProTwo.beans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Embeddable
public class ReviewLikesId implements Serializable {

	//default serialVersionUID
	private static final long serialVersionUID = 1L;

	
	@Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    private Long userId;
	
    @Column(name = "review_id", nullable = false, insertable = false, updatable = false)
    private Long reviewId;

    
    public ReviewLikesId(){super();}
    
    
	public ReviewLikesId(Long userId, Long reviewId) {
		this.userId = userId;
		this.reviewId = reviewId;
	}
	
	public void setReviewLikesId(Long userId, Long reviewId) {
		this.userId = userId;
		this .reviewId = reviewId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reviewId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewLikesId other = (ReviewLikesId) obj;
		return Objects.equals(reviewId, other.reviewId) && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "ReviewLikesId [userId=" + userId + ", reviewId=" + reviewId + "]";
	}
    
    
}
