@Registration 
@All
Feature: User Registration on askomdch.com
  As a new user
  I want to register an account
  So that I can place orders

  Background:
    Given User is on the AskOmDch registration page

  Scenario Outline: Successful registration with valid details
    When User registers with username "<username>", email "<email>", and password "<password>"
    Then User should be redirected to the My Account page

    Examples:
      | username     | email                    | password   |
      | shivkrishna  | shivkrishna@testmail.com | Pass@1234  |
      | nehamona     | neha.mona@testmail.com   | Test@5678  |
