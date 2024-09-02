Feature: Login to Swag Labs
  Different type of users login to Swag Labs

  Scenario Outline: Login with valid user
    Given user is on the login page
    When they login with username <username> and password <password>
    Then they should be redirected to the homepage
    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

  Scenario: Login with locked out user
    Given user is on the login page
    When they login with username locked_out_user and password secret_sauce
    Then they should get a warning message