@login
@All
Feature: Login functionality for registered user

  Scenario: Login with valid credentials
    Given user is on the homepage
    When user clicks on Signup/Login button
    And user enters correct login email "shiva1234567@gmail.com" and password "shiva123456"
    And clicks on login button
    Then user should be logged in successfully
