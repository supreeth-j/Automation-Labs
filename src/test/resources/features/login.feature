Feature: Swag Labs Login functionality
@test
  Scenario: User should able to login to Swag Labs website

    Given User launch chrome browser
    And User opens URL "https://www.saucedemo.com/"
    When User enters username "standard_user"
    And User enters password "secret_sauce"
    And User clicks on Login button
    Then User should navigate to Products page