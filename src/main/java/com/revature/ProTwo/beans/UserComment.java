package com.revature.ProTwo.beans;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class UserComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String CommentText;
	private LocalDateTime sentAt;
	
	@ManyToOne
	@JoinColumn(name="review_id")
	private Review review;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public UserComment() {
		id = 1;
		review = new Review();
		user = new User();
		CommentText = "";
		sentAt = LocalDateTime.now();
	}

	public UserComment(int id, Review review, User user, String commentText, LocalDateTime sentAt) {
		this.id = id;
		this.review = review;
		this.user = user;
		this.CommentText = commentText;
		this.sentAt = sentAt;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Review getReview() {
		return review;
	}


	public void setReview(Review review) {
		this.review = review;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getCommentText() {
		return CommentText;
	}


	public void setCommentText(String commentText) {
		CommentText = commentText;
	}


	public LocalDateTime getSentAt() {
		return sentAt;
	}


	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}


	@Override
	public int hashCode() {
		return Objects.hash(CommentText, id, review, sentAt, user);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserComment other = (UserComment) obj;
		return Objects.equals(CommentText, other.CommentText) && id == other.id
				&& Objects.equals(review, other.review) && Objects.equals(sentAt, other.sentAt)
				&& Objects.equals(user, other.user);
	}


	@Override
	public String toString() {
		return "UserComment [id=" + id + ", review=" + review + ", user=" + user + ", CommentText="
				+ CommentText + ", sentAt=" + sentAt + "]";
	}
	
	
	
}
