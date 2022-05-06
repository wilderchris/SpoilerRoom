
package com.revature.ProTwo.services;

import static org.junit.jupiter.api.Assertions.*;
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

import com.revature.ProTwo.ProTwoApplication;
import com.revature.ProTwo.beans.Movie;
import com.revature.ProTwo.beans.User;
import com.revature.ProTwo.data.UserRepository;
import com.revature.ProTwo.exceptions.IncorrectCredentialsException;
import com.revature.ProTwo.exceptions.UserNotFoundException;
import com.revature.ProTwo.exceptions.UsernameAlreadyExistsException;

@SpringBootTest(classes=ProTwoApplication.class)
public class UserServiceTest {

	@MockBean
	private UserRepository userRepo;
	@MockBean
	private Movie movieRepo;

	@Autowired
	private UserService userServ;

	private static Set<User> mockUsers;

	static String name;

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

	
	//Login
	@Test
	public void logInSuccessfully() throws IncorrectCredentialsException {
		// input setup
		String username="qwertyuiop";
		String password="pass";

		// set up the mocking
		User mockUser = new User();
		mockUser.setUsername(username);
		mockUser.setPassword(password);
		when(userRepo.findByUsername(username)).thenReturn(mockUser);

		// call the method we're testing
		User actualUser = userServ.logIn(username, password);

		// assert the expected behavior/output
		assertEquals(mockUser,actualUser);
	}


	@Test
	public void logInIncorrectPassword() {
		String username="qwertyuiop";
		String password="12345";

		User mockUser = new User();
		mockUser.setUsername(username);
		mockUser.setPassword("pass");
		when(userRepo.findByUsername(username)).thenReturn(mockUser);

		assertThrows(IncorrectCredentialsException.class, () -> {
			userServ.logIn(username, password);
		});
	}


	@Test
	public void logInUsernameDoesNotExist() {
		String username="asdfghjkl";
		String password="pass";

		when(userRepo.findByUsername(username)).thenReturn(null);

		assertThrows(IncorrectCredentialsException.class, () -> {
			userServ.logIn(username, password);
		});
	}

	//Update
	@Test
	public void updateSuccessfully() {
		User mockUser = new User();
		mockUser.setId(1);

		when(userRepo.existsById(1)).thenReturn(true);
		when(userRepo.save(Mockito.any(User.class))).thenReturn(mockUser);
		when(userRepo.findById(1)).thenReturn(Optional.of(mockUser));

		User updatedUser = userServ.updateUser(mockUser);
		assertNotNull(updatedUser);
	}




	// Register
	@Test
	public void registerUserSuccessfully() throws UsernameAlreadyExistsException {
		User user = new User();
		user.setId(10);

		when(userRepo.save(user)).thenReturn(user);

		User actualUser = userServ.register(user);
		assertEquals(10, actualUser.getId());
	}


	
	//Get user by Id

	@Test
	public void getByIdUserExists() throws UserNotFoundException{
		User user = new User();
		user.setId(2);

		when(userRepo.findById(2)).thenReturn(Optional.of(user));

		User actualUser = userServ.getUserById(2);
		assertEquals(user, actualUser);
	}

}


