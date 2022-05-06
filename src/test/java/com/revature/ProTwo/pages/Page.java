package com.revature.ProTwo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Page {

	private WebDriver driver;

	@FindBy(id="username")
	private WebElement usernameInput;
	@FindBy(id="passwd")
	private WebElement passwordInput;
	@FindBy(id="loginBtn")
	private WebElement submitBtn;
	@FindBy(id="sL")
	private WebElement logBtn;



	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void navigateTo(String url) {
		driver.get(url);
		//http://localhost:4200/movie
		//http://localhost:4200/home
	}
	
	
	public void clickLoginButton() {
		logBtn.click();	
	}

	public void submitLogin(String username, String password) {
		//usernameInput.sendKeys(username);
		//passwordInput.sendKeys(password);
		//loginBtn.click();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("passwd")).sendKeys(password);
	}
	
	public void clickSubmitLogin() {
		submitBtn.click();
	}

	// Add Tag element from the front end if not use the next code with ID
	//	public String getErrorMessage() {
	//		WebElement errorMsg = driver.findElement(By.tagName(""));
	//		return errorMsg.getText();
	//	}
//
//	public String getErrorMessage() {
//		WebElement errorMsg = driver.findElement(By.id(""));
//		return errorMsg.getText();
//	}

	
	// This three methods is for Comments
	@FindBy(id="review_id")
	WebElement rvwid;
	@FindBy(id="user_id")
	WebElement userid;
	@FindBy(id="commentText")
	WebElement cmmText;
	@FindBy(id="postComment")
	WebElement cmmSub;
	@FindBy(id="commentMovie")
	WebElement cmmtBtn;
	
	public void commentOnReview(int i, int j, String string) {

		rvwid.sendKeys(String.valueOf(i));
		userid.sendKeys(String.valueOf(j));
		cmmText.sendKeys(string);
	}

	public void postComment() {

		cmmSub.click();	
	}

	public void commentClick() {

		cmmtBtn.click();
	}

	// This two methods is for Edit Profile
	@FindBy(id="firstName") // This can change
	WebElement first;
	@FindBy(id="lastName")	// This can change
	WebElement last;
	@FindBy(id="saveBtn")	// This can change
	WebElement saveBtn;

	public void editProfile(String fst, String lst) {

		first.sendKeys(fst);
		last.sendKeys(lst);
	}

	public void saveEditClick() {

		saveBtn.click();
	}


	// This two methods is for Movie
	@FindBy(id="name") 
	WebElement mName;
	@FindBy(id="year")	
	WebElement mYear;
	@FindBy(id="description") 
	WebElement desc;
	@FindBy(id="rating")	
	WebElement rating;
	@FindBy(id="genre") 
	WebElement genre;
	public void searchMovie(String name, String year, String description, String rating, String genre) {

		mName.sendKeys(name);
		mYear.sendKeys(year);
		desc.sendKeys(description);
		this.rating.sendKeys(rating);
		this.genre.sendKeys(genre);
	}

	@FindBy(id="searchBar")
	WebElement srchBar;
	public void searchBarClick() {

		srchBar.click();
	}

	// This two method is for Review
	@FindBy(id="user") 
	WebElement rUser;
	@FindBy(id="movie")	
	WebElement rMovie;
	@FindBy(id="title") 
	WebElement rTitle;
	@FindBy(id="rName")	
	WebElement movieName;
	@FindBy(id="rating") 
	WebElement rRating;
	public void reviewOnMovie(int user, int movie, String title, String name, int rating) {

		rUser.sendKeys(String.valueOf(user));
		rMovie.sendKeys(String.valueOf(movie));
		rTitle.sendKeys(title);
		movieName.sendKeys(name);
		rRating.sendKeys(String.valueOf(rating));

	}

	@FindBy(id="uploadReview")
	WebElement uploadReview;
	public void uploadReviewClick() {
		uploadReview.click();
	}



}



