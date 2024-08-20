Feature: Login to Swag Labs
  Different type of users login to Swag Labs

  Scenario: Login with standard user
    Given user is on the login page
    When they enter username "standard_user" and password "secret_sauce"
    And they click the login button
    Then they should be redirected to the homepage