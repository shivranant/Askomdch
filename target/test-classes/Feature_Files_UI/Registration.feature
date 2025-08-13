@Registration 
@All


Feature: New User Registration on AutomationExercise

  Scenario: Successful registration with valid details
    Given User launches the application
    When User clicks on Signup Login
    And User enters name "shiva" and email "shiva1234567@gmail.com" for signup
    And User fills registration details with password "shiva123456", first name "shiva", last name "shiva", address "123 Main Street", state "Maharashtra", city "Pune", zip "411001", mobile "9876543210"
    And User clicks on Create Account button
    Then Account should be created successfully
