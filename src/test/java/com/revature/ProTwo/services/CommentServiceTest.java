
package com.revature.ProTwo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;

import com.revature.ProTwo.ProTwoApplication;
import com.revature.ProTwo.beans.Review;
import com.revature.ProTwo.beans.User;
import com.revature.ProTwo.beans.UserComment;
import com.revature.ProTwo.data.UserCommentRepository;
import com.revature.ProTwo.exceptions.CommentNotFoundException;

@SpringBootTest(classes=ProTwoApplication.class)
public class CommentServiceTest {

	@MockBean
	private UserCommentRepository CommentRepo;

	@Autowired
	private CommentService commentServ;

	private static Set<UserComment> mockComments;

	static String name;

	// Mock
	@BeforeAll
	public static void mockUserCommentsSetup() {
		mockComments = new HashSet<>();

		for (int i=1; i<=5; i++) {
			UserComment comment = new UserComment();
			comment.setId(i);
			name = String.valueOf(i);
			if (i<3)
				comment.setCommentText("alchemy" + name);
			mockComments.add(comment);
		}
	}

	private static Set<User> mockUsers;

	@BeforeAll
	public static void mockUsersSetup() {
		mockUsers = new HashSet<>();

		for (int i=1; i<=5; i++) {
			User user = new User();
			user.setId(i);
			name = String.valueOf(i);
			if (i<3)
				user.setFirstName("alchemy" + name);
			mockUsers.add(user);
		}
	}


	//Create
	@Test
	public void addNewCommentSuccessfully() throws CommentNotFoundException {
		UserComment newComment = new UserComment();
		UserComment mockComment = new UserComment();
		mockComment.setId(10);

		when(CommentRepo.save(newComment)).thenReturn(mockComment);

		UserComment newId = commentServ.create(newComment);

		assertNotEquals(null, newId);
	}

	//Delete

	@Test
	public void delete() throws CommentNotFoundException{
		UserComment comment = new UserComment();
		comment.setId(1);
		comment.setCommentText("Delete");

		when(CommentRepo.getById(2)).thenReturn(comment);
		doNothing().when(CommentRepo).delete((Mockito.any(UserComment.class)));
		
		UserComment actual = commentServ.delete(comment);
		assertEquals(comment, actual);
	}

	//viewAllCommentsByUser
	@Test
	public void viewAllCommentsByUser() {
		User user = new User();
		user.setId(2);
		when(CommentRepo.findAllByUserId(2)).thenReturn(mockComments);

		Set<UserComment> actualComments = commentServ.viewAllCommentsByUser(user);

		assertEquals(mockComments, actualComments);
	}

	//viewAllComentsByReview
	@Test
	public void viewAllCommentsByReview() {
		Review review = new Review();
		review.setId(2);
		when(CommentRepo.findAllByReviewId(2)).thenReturn(mockComments);

		Set<UserComment> actualComments = commentServ.viewAllCommentsByReview(review);

		assertEquals(mockComments, actualComments);
	}

	/*private Sort sortByIdAsc() {
		return new Sort(Sort.Direction.ASC, "id");
		//Sort.by(Sort.Direction.DESC, "user_id")
	}*/


}