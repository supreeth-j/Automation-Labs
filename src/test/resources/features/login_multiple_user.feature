Feature: Check login functionality with multiple users
  @smoke
  Scenario Outline: Validate login functionality with multiple users
    Given User is on swag labs web page
    When User enter username as "<USERNAME_DATA>"
    And User enter password as "<PASSWORD_DATA>"
    And User click on Login button
    Then User should navigate to Products page1

    Examples:
      | USERNAME_DATA           | PASSWORD_DATA |
      | standard_user           | secret_sauce  |
      | locked_out_user         | secret_sauce  |
      | problem_user            | secret_sauce  |
      | performance_glitch_user | secret_sauce  |
      | error_user              | secret_sauce  |
      | visual_user             | secret_sauce  |