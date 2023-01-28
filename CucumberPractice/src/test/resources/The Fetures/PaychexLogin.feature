Feature: This is a Paychex login feature file


@PaychexWindowHandle

  Scenario: Verify user can successfully go to the login page
    Given User lunch application URL
    Then User click on login link
    Then User in login page and verify
    Then close the application
