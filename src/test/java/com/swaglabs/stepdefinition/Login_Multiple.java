package com.swaglabs.stepdefinition;

import com.swaglabs.utils.CommonUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.swaglabs.core.BaseClass.launchUrl;

public class Login_Multiple extends CommonUtils {
    private static final Logger logger = LogManager.getLogger(Login_Multiple.class);
    @Given("User is on swag labs web page")
    public void user_is_on_swag_labs_web_page() {
        // Write code here that turns the phrase above into concrete actions
        launchUrl("url");
        logger.info("test passed1");
    }
    @When("User enter username as {string}")
    public void user_enter_username_as(String USERNAME_DATA) {
        // Write code here that turns the phrase above into concrete actions
loginPage.inputUsername(USERNAME_DATA);
    }
    @When("User enter password as {string}")
    public void user_enter_password_as(String PASSWORD_DATA) {
        // Write code here that turns the phrase above into concrete actions
loginPage.inputPassword(PASSWORD_DATA);
    }
    @When("User click on Login button")
    public void user_click_on_login_button() {
        // Write code here that turns the phrase above into concrete actions
loginPage.clickLoginButton();
    }
    @Then("User should navigate to Products page1")
    public void user_should_navigate_to_products_page1() {
        // Write code here that turns the phrase above into concrete actions

    }

}
