package com.revature.ProTwo.steps;

import org.openqa.selenium.WebDriver;

import com.revature.ProTwo.pages.Page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommentStepImpl {
	
	private WebDriver driver;
	private Page page;
	
//	@Given("the user is on the page of a review")
//	public void the_user_is_on_the_page_of_a_review() {
//		
//		driver.get("http://localhost:8080");
//	}

	@When("the user click's comment on a specific movie")
	public void the_user_click_s_comment_on_a_specific_review() {
		page.commentClick();
	}

	@When("the user enters data on the input box")
	public void the_user_enters_data_on_the_input_box() {
		page.commentOnReview(1,1,"I like this movie a lot");
	}

	@Then("the comment is uploaded on the page by clicking the button")
	public void the_comment_is_uploaded_on_the_page_by_clicking_the_button() {
	    page.postComment();
	}
}
