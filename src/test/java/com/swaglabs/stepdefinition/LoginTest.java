package com.swaglabs.stepdefinition;


import com.swaglabs.core.PageInitializer;
import com.swaglabs.utils.CommonUtils;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoginTest extends CommonUtils {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);
    @Given("User launch chrome browser")
    public void user_launch_chrome_browser() {
        // Write code here that turns the phrase above into concrete actions
        launchUrl("url");
        logger.info("test passed");
    }
    @Given("User opens URL {string}")
    public void user_opens_url(String string) {
        // Write code here that turns the phrase above into concrete actions

    }
    @When("User enters username {string}")
    public void user_enters_username(String string) {
        // Write code here that turns the phrase above into concrete actions
        PageInitializer.loginPage.inputUsername("standard_user");
    }
    @When("User enters password {string}")
    public void user_enters_password(String string) {
        // Write code here that turns the phrase above into concrete actions
        PageInitializer.loginPage.inputPassword("secret_sauce");
    }
    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        // Write code here that turns the phrase above into concrete actions
        PageInitializer.loginPage.clickLoginButton();
    }
    @Then("User should navigate to Products page")
    public void user_should_navigate_to_products_page() {
        // Write code here that turns the phrase above into concrete actions

    }

}
