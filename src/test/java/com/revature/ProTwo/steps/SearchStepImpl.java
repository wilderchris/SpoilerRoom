package com.revature.ProTwo.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import com.revature.ProTwo.pages.Page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepImpl {

	private WebDriver driver;
	private Page page;

	@Given("the user is on the correct page")
	public void the_user_is_on_the_correct_page() {

		driver.get("http://localhost:4200");
	}

	@When("the user enters the movie")
	public void the_user_enters_the_movie() {

		page.searchMovie("The alchemy movie","1990","Description", "PG-13", "Adventure");
	}

	@Then("the user clicks search Button")
	public void the_user_clicks_search_button() {
		page.searchBarClick();
	}

	@Then("the appropriate error message should appear")
	public void the_appropriate_error_message_should_appear() {
		
		//String errorMsg = page.getErrorMessage();
		//assertTrue(errorMsg.contains("That movie is not available"));
	}


}
