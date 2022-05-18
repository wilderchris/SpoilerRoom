package com.revature.ProTwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.ProTwo.Utilities.TMDBApi;

@SpringBootApplication
public class ProTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProTwoApplication.class, args);
		
		//System.out.println(TMDBApi.RandomImage("Bad"));
	}


}
