package com.revature.ProTwo.data;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.ProTwo.beans.Movie;
import com.revature.ProTwo.beans.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{
	public Set<Review> findByMovieOrderBySentAtDesc(Movie movie);
}

