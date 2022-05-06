package com.revature.ProTwo.controllers;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ProTwo.beans.Review;
import com.revature.ProTwo.beans.ReviewLikes;
import com.revature.ProTwo.beans.UserComment;
import com.revature.ProTwo.services.ReviewService;

@RestController
@RequestMapping(path = "/review")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {
	private static ReviewService revServ;

	@Autowired
	public ReviewController(ReviewService revServ) {
		ReviewController.revServ = revServ;
	}

	// Post to /review
	@PostMapping
	public ResponseEntity<Void> postReview(@RequestBody Review newReview) {
		if (newReview != null) {
			newReview.setSentAt(LocalDateTime.now());
			revServ.postNewReview(newReview);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	// PUT to /review/like
	@PostMapping(path = "/like")
	public ResponseEntity<Void> likeReview(@RequestBody ReviewLikes newLike) {
		if (newLike != null) {
			System.out.println(newLike);
			revServ.likeReview(newLike);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	// GET to /review/{review_id}/get_comments
	@GetMapping(path = "/{review_id}/get_comments")
	public ResponseEntity<Set<UserComment>> getReviewComments(@PathVariable("review_id") int reviewId) {
		Set<UserComment> allComments = revServ.getAllCommentsForReview(reviewId);
		return ResponseEntity.ok(allComments);
	}
}
