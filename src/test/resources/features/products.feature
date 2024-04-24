Feature: Swag Labs Login functionality
  @reg
  Scenario: User should able to login to Swag Labs website
    Given User on products page
    When User enters clicks on add to cart
    And User succesfully added cart items
    Then User should navigate to Checkout page