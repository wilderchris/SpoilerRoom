package com.revature.ProTwo.beans;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;



@Embeddable
public class MovieRatingId implements Serializable {

	//default serialVersionUID
	private static final long serialVersionUID = 1L;
	
	@Column(name = "user.id", nullable = false, insertable = false, updatable = false)
    private int userId;

    @Column(name = "movie.id", nullable = false, insertable = false, updatable = false)
    private int movieId;

    public MovieRatingId() {
    	this.userId = 0;
        this.movieId = 0;
    }

    public MovieRatingId(int userId, int movieId) {
        this.userId = userId;
        this.movieId = movieId;
    }

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieRatingId other = (MovieRatingId) obj;
		return Objects.equals(movieId, other.movieId) && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "MovieRatingId [userId=" + userId + ", movieId=" + movieId + "]";
	}

	

}