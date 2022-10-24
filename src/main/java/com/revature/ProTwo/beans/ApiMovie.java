package com.revature.ProTwo.beans;


import java.util.List;
import java.util.Objects;

public class ApiMovie {

	private long id;

	private String title;

	private String release_date;

	private String overview;

	// private String movieRating;

	private List<Integer> genre;
	private String poster_path;

	private String key;

	public ApiMovie() {
		super();
	}

	public ApiMovie(long id, String title,List<Integer> genre, String release_date, String overview, String poster_path) {
		super();
		this.id = id;
		this.title = title;
		this.release_date = release_date;
		this.overview = overview;
		this.genre = genre;

		this.poster_path = poster_path;
	}

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public List<Integer> getGenre() {
		return genre;
	}

	public void setGenre(List<Integer> genre) {
		this.genre = genre;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		return Objects.hash(genre, id, key, overview, poster_path, release_date, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiMovie other = (ApiMovie) obj;
		return Objects.equals(genre, other.genre) && id == other.id && Objects.equals(key, other.key)
				&& Objects.equals(overview, other.overview) && Objects.equals(poster_path, other.poster_path)
				&& Objects.equals(release_date, other.release_date) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "ApiMovie [id=" + id + ", title=" + title + ", release_date=" + release_date + ", overview=" + overview
				+ ", genre=" + genre + ", poster_path=" + poster_path + ", key=" + key + "]";
	}

	

	

}