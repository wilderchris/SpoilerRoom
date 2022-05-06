package com.revature.ProTwo.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.ProTwo.beans.MovieRating;
import com.revature.ProTwo.beans.MovieRatingId;

@Repository
public interface MovieRatingRepository extends CrudRepository<MovieRating, MovieRatingId>{
	
}
