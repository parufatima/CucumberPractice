Feature: This is an Amazon feature file

@AmazonSearch
  Scenario: Verify User can successfully navigate to the Home decor page
    Given User lunch application URL
    When User enter Home decor in search field
    And click on search button
    Then Verify User successfully navigate to the home decor page
   