package com.revature.ProTwo.steps;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.revature.ProTwo.pages.Page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepImpl {

	private Page page;
	private WebDriver driver = null;

	{
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
		page = new Page(driver);
	}


	




	@Given("user is on login page")
	public void user_is_on_login_page() {

		page.navigateTo("http://localhost:4200/home");
		page.clickLoginButton();
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {

		page.submitLogin("buster", "pass");
	}

	@And("user click on Submit")
	public void user_click_on_submit() {

		page.clickSubmitLogin();
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(50));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("lo"), 0));

		driver.findElement(By.id("lo")).isDisplayed();
		driver.quit();
	}

}
