package com.revature.ProTwo.steps;

import org.checkerframework.checker.optional.qual.Present;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReviewStepImpl {
	

	
public static WebDriver driver;
//public List<WebElement> revBtn;
	@BeforeAll
	public static void setupDriver() {
		File file = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		
		ChromeOptions options=new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String,Object>();
		//1-Allow, 2-Block, 0-default
		prefs.put("profile.default_content_setting_values.alerts", 1);
		options.setExperimentalOption("prefs",prefs);

		driver = new ChromeDriver(options);
	}

	@Given("the user is on the page of a review")
	public void the_user_is_on_the_page_of_a_review() throws InterruptedException {
	    
		driver.get("http://localhost:4200/movie");
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(50));
		wait1.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("13"), 0));

		
		WebElement revBtn = driver.findElement(By.id("13"));
		revBtn.click();

	}

	@When("the user can enter a review on the input box")
	public void the_user_can_enter_a_review_on_the_input_box() {
		WebElement revtitle = driver.findElement(By.id("revtitle"));
		WebElement revdesc = driver.findElement(By.id("revtext"));
		//WebElement revrating = driver.findElement(By.id("revrate"));
		WebElement revRating = driver.findElement(By.id("revrate"));
		Actions action = new Actions(driver);
		revtitle.sendKeys("Selenium Title");
		revdesc.sendKeys("Selenium Description");
		
		
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(50));
		wait1.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("revrate"), 0));
		
		
		
//		revRating.getLocation().;		
		//revRating.click();
		action.moveToElement(revRating).click();
		action.build().perform();

		WebElement revsubBtn = driver.findElement(By.id("revsubbtn"));

		revsubBtn.click();
		//page.reviewOnMovie(1,1,"I really like this movie","Movie",4);
	}

	@Then("review is uploaded on the page of the movie by clicking the button")
	public void review_is_uploaded_on_the_page_of_the_movie_by_clicking_the_button() {
	boolean check =false;
		try {
		List<WebElement> rev = driver.findElements(By.id("revrate"));
		}catch(StaleElementReferenceException e) {
			check = true;
		}
		// 
		assertTrue(check);
	}
	
	
	
	
	public boolean checkAlert() {
		try {
			Wait<WebDriver> waitx = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5));
			waitx.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
			return true;
		} catch (Exception e) {

		}
		return false;
	}
	
	
	@AfterAll
	public static void closeDriver() {
		driver.switchTo().alert().accept();
		driver.close();
		driver.quit();
	}
}
