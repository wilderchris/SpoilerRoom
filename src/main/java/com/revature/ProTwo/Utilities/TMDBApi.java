package com.revature.ProTwo.Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ProTwo.beans.ApiMovie;
import com.revature.ProTwo.beans.Genre;

public class TMDBApi {
	private static String apiKey = API_KEY;
	private static int responsecode = 0;

	public static ApiMovie getById(long id) {
		URL url = null;
		try {
			url = new URL(
					"https://api.themoviedb.org/3/movie/" + id + "?api_key=" + apiKey + "&language=en-US");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Get the required object from the above created object
		JSONObject data_obj;// = new JSONObject();
		
		
		try {

			conn.setRequestMethod("GET");// hard coded my api key for now
			conn.connect();

			// Getting the response code
			responsecode = conn.getResponseCode();

			if (responsecode != 200) {
				throw new RuntimeException("HttpResponseCode: " + responsecode);
			} else {

				String inline = "";
				String sb = "";

				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

				while ((inline = br.readLine()) != null) {
					sb += (inline + "\n");
				}

				br.close();

				// Using the JSON simple library parse into a json object
				JSONParser parse = new JSONParser();
				data_obj = (JSONObject) parse.parse(sb);

			}
			ApiMovie apiMov = new ApiMovie();
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			JSONObject new_obj = (JSONObject) data_obj;
			apiMov = mapper.convertValue(new_obj, ApiMovie.class);
			apiMov.setKey(videoLink(id));

			return apiMov;

		} catch (Exception e) {
			return null;

		}
		
	}
	
	public static ApiMovie[] APIGenreQuery(String genre) {// arg = genre query // new for a myhome page algo
		URL movieUrl = null;    //https://api.themoviedb.org/3/movie/top_rated?api_key=   &language=en-US&page=1
		URL GListUrl = null; //"https://api.themoviedb.org/3/genre/movie/list?api_key= X  &language=en-US";
		try {
			movieUrl = new URL( 
					"https://api.themoviedb.org/3/movie/top_rated?api_key=" + apiKey + "&language=en-US");
			GListUrl = new URL( 
					"https://api.themoviedb.org/3/genre/movie/list?api_key=" + apiKey + "&language=en-US");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		HttpURLConnection conn = null;
		HttpURLConnection conn1 = null;

		try {
			conn1 = (HttpURLConnection) movieUrl.openConnection();

			conn = (HttpURLConnection) GListUrl.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Get the required object from the above created object
		JSONArray obj = Connection(conn);
		JSONArray obj1 = Connection(conn1);

		Genre[] gList = new Genre[obj.size()];
		ApiMovie[] apiMov = new ApiMovie[obj1.size()];

		//ApiMovie[] apiMov = new ApiMovie[obj.size()];
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		for (int i = 0; i < obj.size(); i++) {
			// takes the JSONArray and writes to JSONObject the to string array
			JSONObject new_obj = (JSONObject) obj.get(i);
			gList[i] = mapper.convertValue(new_obj, Genre.class);
		}
		for (int i = 0; i < obj1.size(); i++) {
			// takes the JSONArray and writes to JSONObject the to string array
			JSONObject new_obj1 = (JSONObject) obj1.get(i);
			apiMov[i] = mapper.convertValue(new_obj1, ApiMovie.class);
		}
		ApiMovie[] aMov = new ApiMovie[obj1.size()];
		// comparator for genre and refactor
		for (int i = 0; i < gList.length; i++) {
			if( gList[i].getName().toLowerCase() == genre.toLowerCase() ) {
					if ( apiMov[i].getGenre().contains(gList[i].getId()) ) {
						 
					}
				
				////need to work out the genre algo for comparison and return
				// refactoring needed
			}
		
		}
		
		
		
		
		for (int i = 0; i < aMov.length; i++) {
			aMov[i].setKey(videoLink(aMov[i].getId()));
		}
		return aMov;
	}
	
	
	
	
	public static ApiMovie[] APIQuery(String type) {// arg = search query
		URL queryUrl = null;

		try {
			queryUrl = new URL(
					"https://api.themoviedb.org/3/search/movie?api_key=" + apiKey + "&language=en-US&query=" + type);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) queryUrl.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Get the required object from the above created object
		JSONArray obj = Connection(conn);
		ApiMovie[] apiMov = new ApiMovie[obj.size()];
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		for (int i = 0; i < obj.size(); i++) {

			// takes the JSONArray and writes to JSONObject the to string array
			JSONObject new_obj = (JSONObject) obj.get(i);
			apiMov[i] = mapper.convertValue(new_obj, ApiMovie.class);

		}
		for (int i = 0; i < apiMov.length; i++) {
			apiMov[i].setKey(videoLink(apiMov[i].getId()));
		}
		return apiMov;
	}

	public static ApiMovie[] newMovies() {

		URL newMoviesUrl = null;

		try {
			newMoviesUrl = new URL("https://api.themoviedb.org/3/movie/upcoming?api_key=" + apiKey + "&language=en-US");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) newMoviesUrl.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Get the required object from the above created object
		JSONArray obj = Connection(conn);
		String[] ranImage = new String[obj.size()];
		ApiMovie[] apiMov = new ApiMovie[obj.size()];
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		for (int i = 0; i < obj.size(); i++) {

			// takes the JSONArray and writes to JSONObject the to string array
			JSONObject new_obj = (JSONObject) obj.get(i);
			ranImage[i] = (String) new_obj.get("poster_path");
			apiMov[i] = mapper.convertValue(new_obj, ApiMovie.class);

		}
		for (int i = 0; i < apiMov.length; i++) {
			apiMov[i].setKey(videoLink(apiMov[i].getId()));
		}
		return apiMov;
	}

	public static String videoLink(long id) {

		URL vidUrl = null;
		try {
			vidUrl = new URL(
					"https://api.themoviedb.org/3/movie/" + id + "/videos?api_key=" + apiKey + "&language=en-US");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} // page

		HttpURLConnection conn = null;
		try {
			conn = (HttpURLConnection) vidUrl.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Get the required object from the above created object
		JSONArray obj = Connection(conn);

		String movieKey = new String();

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		for (int i = 0; i < obj.size(); i++) {
			JSONObject new_obj = (JSONObject) obj.get(i);

			if (new_obj.containsValue("Official Trailer")) {
				movieKey = (String) (new_obj.get("key"));
			}

		}
		return movieKey;
	}

	public static JSONArray Connection(HttpURLConnection conn) {

		JSONObject data_obj;

		try {

			conn.setRequestMethod("GET");// hard coded my api key for now
			conn.connect();

			// Getting the response code
			responsecode = conn.getResponseCode();

			if (responsecode != 200) {
				throw new RuntimeException("HttpResponseCode: " + responsecode);
			} else {

				String inline = "";
				String sb = "";

				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));

				while ((inline = br.readLine()) != null) {
					sb += (inline + "\n");
				}

				br.close();

				// Using the JSON simple library parse into a json object
				JSONParser parse = new JSONParser();
				data_obj = (JSONObject) parse.parse(sb);

			}
			return (JSONArray) data_obj.get("results");

		} catch (Exception e) {
			return null;

		}
	}

}
