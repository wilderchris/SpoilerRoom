Feature: Searching in the Movie Site

  	Scenario: Search correctly
    	Given the user is on the correct page
    	When the user enters the movie
    	Then the user clicks search Button
    	
    Scenario: Search Incorrectly
    	Given the user is on the correct page
    	When the user enters the movie 
    	Then the appropriate error message should appear   
