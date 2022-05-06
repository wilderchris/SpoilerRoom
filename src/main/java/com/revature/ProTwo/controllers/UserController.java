package com.revature.ProTwo.controllers;

import java.util.HashMap;
import java.util.Map;
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

import com.revature.ProTwo.beans.User;
import com.revature.ProTwo.exceptions.IncorrectCredentialsException;
import com.revature.ProTwo.exceptions.UsernameAlreadyExistsException;
import com.revature.ProTwo.services.UserService;

@RestController
@RequestMapping(path="/user")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	private static UserService userServ;

	@Autowired
	public UserController(UserService userServ) {
		
		UserController.userServ=userServ;
	}

	// POST to /user
	@PostMapping
	public ResponseEntity<Map<String, Integer>> register(@RequestBody User newUser) {
		try {
			newUser = userServ.register(newUser);
			Map<String, Integer> newIdMap = new HashMap<>();
			newIdMap.put("generatedId", newUser.getId());
			return ResponseEntity.status(HttpStatus.CREATED).body(newIdMap);
		} catch (UsernameAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	// POST to /user/auth
	@PostMapping(path = "/auth")
	public ResponseEntity<String> logIn(@RequestBody Map<String, String> credentials) {
		String username = credentials.get("username");
		String password = credentials.get("passwd");

		try {
			User user = userServ.logIn(username, password);
			String token = Long.toString(user.getId());//user.getRank().getId());
			return ResponseEntity.ok(token);
		} catch (IncorrectCredentialsException e) {
			return ResponseEntity.notFound().build();
		}
	}

	// GET to /user/{userId}/auth
	@GetMapping(path = "/{userId}/auth")
	public ResponseEntity<User> checkLogin( @PathVariable int userId) {
		User loggedInUser = userServ.getUserById(userId);
		if (loggedInUser != null) {
			return ResponseEntity.ok(loggedInUser);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	// GET to /user/{userId}
	@GetMapping(path = "/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId) {
		User user = userServ.getUserById(userId);
		if (user != null)
			return ResponseEntity.ok(user);
		else
			return ResponseEntity.notFound().build();
	}

	// PUT to /user/{userId}
	@PutMapping(path = "/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User userToEdit, @PathVariable int userId) {
		if (userToEdit != null && userToEdit.getId() == userId) {
			userToEdit = userServ.updateUser(userToEdit);
			if (userToEdit != null)
				return ResponseEntity.ok(userToEdit);
			else
				return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
