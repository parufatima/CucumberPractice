Feature: This is a Demoblez Login feature

Scenario: Verify user can login successfullly
Given User lunch application URL
When User  click login link
When User enter name in username field
When User enter password in password field
And User click on login button
Then user login successfully
Then close the application 
