Feature: User can comment on a review

	Scenario: Posting a comment on a Review
    	Given the user is on the page of a review
    	When the user click's comment on a specific movie
    	And the user enters data on the input box
    	Then the comment is uploaded on the page by clicking the button
