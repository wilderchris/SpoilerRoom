package com.revature.ProTwo.Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ProTwo.beans.ApiMovie;

public class TMDBApi {
	private static String apiKey = "66aa79850db1fa69dcd6bf4bca65021e";
	private static int responsecode = 0;

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
