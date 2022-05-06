package com.revature.ProTwo.beans;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

//For IdClass method
//import javax.persistence.Id;
//import javax.persistence.IdClass;

//For IdClass method
//@IdClass(MovieRatingId.class)
@Entity
public class MovieRating {

	//For IdClass method
	//@Id
	//private User user;
	//@Id
	//private Movie movie;
	
	@EmbeddedId
	private MovieRatingId movieRatingId;	
	@Column(name="rating")
	private int userRating;
	
	public MovieRating() {super();}
	
	public MovieRating(MovieRatingId movieRatingId, int userRating) {
        this.movieRatingId = movieRatingId;
        this.userRating = userRating;
    }

	public MovieRatingId getMovieRatingId() {
		return movieRatingId;
	}

	public void setMovieRatingId(MovieRatingId movieRatingId) {
		this.movieRatingId = movieRatingId;
	}

	public int getUserRating() {
		return userRating;
	}

	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieRatingId, userRating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieRating other = (MovieRating) obj;
		return Objects.equals(movieRatingId, other.movieRatingId) && userRating == other.userRating;
	}

	@Override
	public String toString() {
		return "MovieRating [movieRatingId=" + movieRatingId + ", userRating=" + userRating + "]";
	}


}
