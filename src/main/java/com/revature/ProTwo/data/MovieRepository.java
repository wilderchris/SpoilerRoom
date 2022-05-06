package com.revature.ProTwo.data;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.ProTwo.beans.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
	public Set<Movie> findByMovieNameContainingIgnoreCase(String movieName);
	public Set<Movie> findByYear(String year);
	public Set<Movie> findByGenre(String genre);
}

