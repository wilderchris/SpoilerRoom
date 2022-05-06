package com.revature.ProTwo.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.ProTwo.beans.Movie;
import com.revature.ProTwo.beans.MovieRating;
import com.revature.ProTwo.beans.Review;
import com.revature.ProTwo.data.MovieRatingRepository;
import com.revature.ProTwo.data.MovieRepository;
import com.revature.ProTwo.data.ReviewRepository;
import com.revature.ProTwo.exceptions.MovieAlreadyExistsException;
import com.revature.ProTwo.exceptions.MovieNotFoundException;

@Service
public class MovieServiceImpl implements MovieService{
	
	private MovieRepository movieRepo;
	private ReviewRepository revRepo;
	private MovieRatingRepository ratingRepo;
	// constructor injection
	@Autowired
	public MovieServiceImpl(MovieRepository movieRepo, ReviewRepository revRepo, MovieRatingRepository ratingRepo)  {
		this.movieRepo = movieRepo;
		this.revRepo = revRepo;
		this.ratingRepo = ratingRepo;
	}

	@Override
	public Movie create(Movie movie) throws MovieAlreadyExistsException{
		
		int newId = movieRepo.save(movie).getId();

		if (newId > 0) {
			movie.setId(newId);
			return movie;
		} 
		return null;
	}

	@Override
	public void delete(Movie movie) throws MovieNotFoundException {
		
		movieRepo.delete(movie);
	}

	@Override
	public Movie getMovieById(int id) throws MovieNotFoundException {
		
		 return movieRepo.findById(id).get();
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS)
	public Movie updateMovie(Movie movie) {
		
		 if (movieRepo.existsById(movie.getId())) {
			movieRepo.save(movie);
			movie = movieRepo.findById(movie.getId()).get();
			return movie;
		}
		return null;
	}
@Override
public List<Movie> viewMovies(){
	return movieRepo.findAll();
}
	
	@Override
	public Set<Movie> getMovieByGenre(String genre) {
		return movieRepo.findByGenre(genre);
	}

	@Override
	public Set<Movie> getByYear(String year) {
		return movieRepo.findByYear(year);
	}

	@Override
	public Set<Movie> getMovieByName(String name) {
		return movieRepo.findByMovieNameContainingIgnoreCase(name);
	}
	
	@Override
	public Set<Review> getAllReviewsForMovie(int movieId) {
		return revRepo.findByMovieOrderBySentAtDesc(movieRepo.findById(movieId).get());
	}
	
	@Override
	public void rateMovie(MovieRating newRating) {
		ratingRepo.save(newRating);	
	}
}
