
package com.revature.ProTwo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;

import com.revature.ProTwo.ProTwoApplication;
import com.revature.ProTwo.beans.Movie;
import com.revature.ProTwo.beans.MovieRating;
import com.revature.ProTwo.beans.MovieRatingId;
import com.revature.ProTwo.beans.Review;
import com.revature.ProTwo.beans.ReviewLikes;
import com.revature.ProTwo.beans.ReviewLikesId;
import com.revature.ProTwo.beans.User;
import com.revature.ProTwo.beans.UserComment;
import com.revature.ProTwo.data.ReviewRepository;
import com.revature.ProTwo.data.UserCommentRepository;



@SpringBootTest(classes=ProTwoApplication.class)
public class ReviewServiceTest {

	@MockBean
	private ReviewRepository reviewRepo;

	@Autowired
	private ReviewService reviewServ;

	private static Set<Review> mockReviews;

	static String name;

	// Mock
	@BeforeAll
	public static void mockReviewsSetup() {
		mockReviews = new HashSet<>();

		for (int i=1; i<=5; i++) {
			Review review = new Review();
			review.setId(i);
			name = String.valueOf(i);
			if (i<3)
				review.setReviewText("alchemy" + name);
			mockReviews.add(review);
		}
	}


	//postNewReview, add
	@Test
	public void postNewReviewSuccessfully() {
		Review newReview = new Review();

		Review mockReview = new Review();
		mockReview.setId(10);

		when(reviewRepo.save(newReview)).thenReturn(mockReview);

		Review newId = reviewServ.postNewReview(newReview);

		assertNotEquals(null, newId);
	}

	//viewAllCommentsByReview

	@MockBean
	private UserCommentRepository CommentRepo;

	@Autowired
	private CommentService commentServ;

	private static Set<UserComment> mockComments;

	static String name1;

	// Mock
	@BeforeAll
	public static void mockUserCommentsSetup() {
		mockComments = new HashSet<>();

		for (int i=1; i<=5; i++) {
			UserComment comment = new UserComment();
			comment.setId(i);
			name = String.valueOf(i);
			if (i<3)
				comment.setCommentText("alchemy" + name1);
			mockComments.add(comment);
		}
	}


	@Test
	public void viewAllCommentsByReview() {
		Review review = new Review();
		review.setId(0);

		when(CommentRepo.findAllByReviewId(review.getId())).thenReturn(mockComments);

		Set<UserComment> actualReviews = commentServ.viewAllCommentsByReview(review);
		assertEquals(mockComments, actualReviews);
	}


	// likeReview 		Composite Key		Boolean


	//getReviewById
	@Test
	public void getReviewById() { //By Id
		Review review = new Review();
		review.setId(2);

		when(reviewRepo.findById(2)).thenReturn(Optional.of(review));

		Review actualReviews = reviewServ.getReviewById(2);

		assertEquals(review, actualReviews);

	}

}

