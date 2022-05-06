package com.revature.ProTwo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ProTwo.beans.Movie;
import com.revature.ProTwo.beans.MovieRating;
import com.revature.ProTwo.beans.Review;
import com.revature.ProTwo.exceptions.MovieAlreadyExistsException;
import com.revature.ProTwo.exceptions.MovieNotFoundException;

import com.revature.ProTwo.services.MovieService;

@RestController
@RequestMapping(path = "/movie")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {
	
	private static MovieService movieServ;

	@Autowired
	public MovieController(MovieService movieServ) {
		MovieController.movieServ = movieServ;
	}

	@GetMapping
	public ResponseEntity<List<Movie>> getMovies() {
		
		List<Movie> allMovies = movieServ.viewMovies();
		return ResponseEntity.ok(allMovies);
	}

	
	@PostMapping
	public ResponseEntity<Map<String, Integer>> create(@RequestBody Movie newMovie) {

		try {
			newMovie = movieServ.create(newMovie);
			Map<String, Integer> newIdMap = new HashMap<>();
			newIdMap.put("generatedId", newMovie.getId());
			return ResponseEntity.status(HttpStatus.CREATED).body(newIdMap);
		} catch (MovieAlreadyExistsException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	// GET to /movie/{movieId}
	@GetMapping(path = "/{movieId}")
	public ResponseEntity<Movie> getMovieById(@PathVariable int movieId) throws MovieNotFoundException {
		Movie movie = movieServ.getMovieById(movieId);
		if (movie != null)
			return ResponseEntity.ok(movie);
		else
			return ResponseEntity.notFound().build();
	}

	// PUT to /movie/{movieId}
	@PutMapping(path = "/{movieId}")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movieToEdit, @PathVariable int movieId) {
		try {
			Movie movie = movieServ.getMovieById(movieId);
			if (movieToEdit != null) {
				movie = movieToEdit;
				movie.setId(movieId);
				movie = movieServ.updateMovie(movie);
				if (movie != null)
					return ResponseEntity.ok(movie);
				else
					return ResponseEntity.notFound().build();
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
		} catch (MovieNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		/*
		 * } if (movieToEdit != null && movieToEdit.getId() == movieId) { movieToEdit =
		 * movieServ.updateMovie(movieToEdit); if (movieToEdit != null) return
		 * ResponseEntity.ok(movieToEdit); else return
		 * ResponseEntity.notFound().build(); } else { return
		 * ResponseEntity.status(HttpStatus.CONFLICT).build(); }
		 */
	}

	// GET to /movie/name_search?name=
	@GetMapping(path = "/name_search")
	public ResponseEntity<Set<Movie>> getMovieByName(@RequestParam String name) throws MovieNotFoundException {
		Set<Movie> movie = movieServ.getMovieByName(name);
		if (movie != null)
			return ResponseEntity.ok(movie);
		else
			return ResponseEntity.notFound().build();
	}

	// GET to /movie/genre_search?genre=
	@GetMapping(path = "/genre_search")
	public ResponseEntity<Set<Movie>> getMovieByGenre(@RequestParam String genre) throws MovieNotFoundException {
		Set<Movie> movie = movieServ.getMovieByGenre(genre);
		if (movie != null)
			return ResponseEntity.ok(movie);
		else
			return ResponseEntity.notFound().build();
	}

	// GET to /movie/year_search?year=
	@GetMapping(path = "/year_search")
	public ResponseEntity<Set<Movie>> getMovieByYear(@RequestParam String year) throws MovieNotFoundException {
		Set<Movie> movie = movieServ.getByYear(year);
		if (movie != null)
			return ResponseEntity.ok(movie);
		else
			return ResponseEntity.notFound().build();
	}

	// Get to /movie/{movie_id}/get_reviews
	@GetMapping(path = "/{movie_id}/get_reviews")
	public ResponseEntity<Set<Review>> getReviewsForMovie(@PathVariable("movie_id") int movieId) {
		Set<Review> allReviewsForMovie = movieServ.getAllReviewsForMovie(movieId);
		return ResponseEntity.ok(allReviewsForMovie);
	}

	// Post to /movie/{movie_id}/rate
	@PutMapping(path = "/{movie_id}/rate")//////??????????????????????
	public ResponseEntity<Void> rateMovie(@RequestBody MovieRating newRating,
			@PathVariable("movie_id") int movieId) {
		if (newRating != null) {
			System.out.println(newRating);
			movieServ.rateMovie(newRating);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
