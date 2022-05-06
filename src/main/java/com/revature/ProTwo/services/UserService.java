package com.revature.ProTwo.services;

import com.revature.ProTwo.beans.User;
import com.revature.ProTwo.exceptions.IncorrectCredentialsException;
import com.revature.ProTwo.exceptions.UsernameAlreadyExistsException;

public interface UserService {
	public User register(User newUser) throws UsernameAlreadyExistsException;
	public User logIn(String username, String password) throws IncorrectCredentialsException;
	public User getUserById(int id);
	public User updateUser(User userToUpdate);
}
