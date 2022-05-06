package com.revature.ProTwo.beans;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String movieName;
	
	@Column(name="movie_year")
	private int year;
	
	private String description;
	
	private String movieRating;
	
	private String genre;
	private String image;
	public Movie() {

		id = 1;
		movieName = "";
		year = 0;
		description = "";
		movieRating = "";
		genre = "";
		image="";
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Movie(int id) {
		super();
		this.id = id;
	}
	public Movie(String name) {//?
		super();
		this.movieName = name;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, genre, id, movieName, movieRating, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(description, other.description) && Objects.equals(genre, other.genre)
				&& id == other.id && Objects.equals(movieName, other.movieName)
				&& Objects.equals(movieRating, other.movieRating) && year == other.year;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", year=" + year + ", description="
				+ description + ", movieRating=" + movieRating + ", genre=" + genre + "]";
	}
	
}
