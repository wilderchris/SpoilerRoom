package com.revature.ProTwo.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.revature.ProTwo.pages.Page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditProfileStepImpl {
	
	private WebDriver driver;
	private Page page;

	@Given("the user is on the edit profile page")
	public void the_user_is_on_the_edit_profile_page() {

		driver.get("http://localhost:8080");
	}

	
	@When("the user enters new data")
	public void the_user_enters_new_data(String fst, String lst) {
		
		page.editProfile(fst, lst);
	}

	@Then("the user saves the data by clicking save")
	public void the_user_saves_the_data_by_clicking_save() {
	    
		page.saveEditClick();
	}

}
