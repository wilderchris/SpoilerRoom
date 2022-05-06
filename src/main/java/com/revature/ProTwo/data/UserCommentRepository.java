package com.revature.ProTwo.data;

import java.util.Set;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.ProTwo.beans.Review;
import com.revature.ProTwo.beans.UserComment;

@Repository
public interface UserCommentRepository extends JpaRepository<UserComment, Integer>{
	public Set<UserComment> findByReviewOrderBySentAtDesc(Review review);

	public Set<UserComment> findAllByReviewId(int reviewid);

	public Set<UserComment> findAllByUserId(int userid);
}


