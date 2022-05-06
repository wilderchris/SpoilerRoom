package com.revature.ProTwo.data;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.ProTwo.beans.User;

@Repository
@Table(name="p_user")
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByUsername(String username);
//	public Set<User> findByUserRank(UserRank rank);
}


