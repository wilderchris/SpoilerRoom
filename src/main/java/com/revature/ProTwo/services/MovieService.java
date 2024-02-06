package com.revature.ProTwo.services;

import java.util.List;
import java.util.Set;

import com.revature.ProTwo.beans.ApiMovie;
import com.revature.ProTwo.beans.Movie;
import com.revature.ProTwo.beans.MovieRating;
import com.revature.ProTwo.beans.Review;
import com.revature.ProTwo.exceptions.MovieAlreadyExistsException;
import com.revature.ProTwo.exceptions.MovieNotFoundException;
public interface MovieService {
	
	
	public ApiMovie[] getMovieByQuery(String query);
	public ApiMovie[] getNewMovies();
	public Movie create(Movie movie) throws MovieAlreadyExistsException;
	public Movie updateMovie(Movie movie);
	
	public Movie getMovieById(int id) throws MovieNotFoundException;
	public ApiMovie[] getMovieByGenre(String genre);
	public Set<Movie> getByYear(String year);
	public Set<Movie> getMovieByName(String name);
	
	public void rateMovie(MovieRating newRating);
	public Set<Review> getAllReviewsForMovie(int movieId);
}
