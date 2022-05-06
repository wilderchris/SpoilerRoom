package com.revature.ProTwo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.ProTwo.beans.User;
import com.revature.ProTwo.data.UserRepository;
import com.revature.ProTwo.exceptions.IncorrectCredentialsException;
import com.revature.ProTwo.exceptions.UsernameAlreadyExistsException;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepo;

	
	// constructor injection
	@Autowired
	public UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public User register(User newUser) throws UsernameAlreadyExistsException {
		int newId = userRepo.save(newUser).getId();
		if (newId > 0) {
			newUser.setId(newId);
			return newUser;
		} else if (newId == -1) {
			throw new UsernameAlreadyExistsException();
		}
		return null;
	}

	@Override
	public User logIn(String username, String password) throws IncorrectCredentialsException {
		User personFromDatabase = userRepo.findByUsername(username);
		if (personFromDatabase != null && personFromDatabase.getPassword().equals(password)) {
			return personFromDatabase;
		} else {
			throw new IncorrectCredentialsException();
		}
	}
	
	@Override
	public User getUserById(int id) {
		return userRepo.findById(id).get();
	}
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public User updateUser(User userToUpdate) {
		if (userRepo.existsById(userToUpdate.getId())) {
			userRepo.save(userToUpdate);
			userToUpdate = userRepo.findById(userToUpdate.getId()).get();
			return userToUpdate;
		}
		return null;
	}

}

