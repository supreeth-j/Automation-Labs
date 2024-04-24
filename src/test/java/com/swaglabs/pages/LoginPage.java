package com.swaglabs.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver)
    {

        PageFactory.initElements(driver, this);
    }

    //Sore all the web elements
    @FindBy(id ="user-name")
    WebElement username_element;
    @FindBy(id ="password")
    WebElement password_element;
    @FindBy(id ="login-button")
    WebElement logIn_btn_element;


    public void inputUsername(String uname){
        username_element.sendKeys(uname);

    }

    public void inputPassword(String pwd){

        password_element.sendKeys(pwd);
    }
    public void clickLoginButton() {

        logIn_btn_element.click();

    }
}
