package com.swaglabs.stepdefinition;

import com.swaglabs.core.PageInitializer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.swaglabs.core.BaseClass.launchUrl;

public class Products_Page  {

    @Given("User on products page")
    public void user_on_products_page() {
        // Write code here that turns the phrase above into concrete actions
        //launchUrl("url");
        launchUrl("url");
        PageInitializer.loginPage.inputUsername("standard_user");
        PageInitializer.loginPage.inputPassword("secret_sauce");
        PageInitializer.loginPage.clickLoginButton();


    }
    @When("User enters clicks on add to cart")
    public void user_enters_clicks_on_add_to_cart() {
        // Write code here that turns the phrase above into concrete actions
        PageInitializer.productsPage.clickaddcart();
    }
    @When("User succesfully added cart items")
    public void user_succesfully_added_cart_items() {
        // Write code here that turns the phrase above into concrete actions
PageInitializer.productsPage.shopped_bsg();
    }
    @Then("User should navigate to Checkout page")
    public void user_should_navigate_to_checkout_page() {
        // Write code here that turns the phrase above into concrete actions

    }

}
