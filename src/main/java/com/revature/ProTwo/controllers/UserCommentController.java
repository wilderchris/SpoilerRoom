package com.revature.ProTwo.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ProTwo.beans.User;
import com.revature.ProTwo.beans.UserComment;
import com.revature.ProTwo.exceptions.CommentNotFoundException;
import com.revature.ProTwo.services.CommentService;
import com.revature.ProTwo.services.ReviewService;
import com.revature.ProTwo.services.UserService;

@RestController
@RequestMapping(path = "/comment")
@CrossOrigin(origins = "http://localhost:4200")
public class UserCommentController {

	private static CommentService cmmServ;
	private static UserService userServ;
	@Autowired
	public UserCommentController(CommentService cmmServ, UserService userServ) {
		UserCommentController.cmmServ = cmmServ;
		UserCommentController.userServ = userServ;
	}

	// POST to /comment
	@PostMapping
	public ResponseEntity<Map<String, Integer>> create(@RequestBody UserComment newUserCmm) {

		try {
			newUserCmm = cmmServ.create(newUserCmm);
			Map<String, Integer> newIdMap = new HashMap<>();
			newIdMap.put("generatedId", newUserCmm.getId());
			return ResponseEntity.status(HttpStatus.CREATED).body(newIdMap);
		} catch (CommentNotFoundException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	// GET to /comment/user/{user_id}
	@GetMapping(path = "/user/{user_id}")
	public ResponseEntity<Set<UserComment>> getUserComments(@PathVariable("user_id") int userId) {
		//System.out.println(userId);
		Set<UserComment> cmnt = cmmServ.viewAllCommentsByUser(userServ.getUserById(userId));
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(cmnt);
	}

	// POST to /comment/{comment_id}/delete,
	@PostMapping(path = "{comment_id}/delete")
	public ResponseEntity<Map<String, Integer>> delete(@PathVariable("comment_id") int commentId)
			throws CommentNotFoundException {

		UserComment deletedUserCmm = cmmServ.delete(cmmServ.getCommentById(commentId));
		Map<String, Integer> newIdMap = new HashMap<>();
		newIdMap.remove("generatedId", deletedUserCmm.getId());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newIdMap);
	}
}
