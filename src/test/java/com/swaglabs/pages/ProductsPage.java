package com.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    public ProductsPage(WebDriver driver)
    {

        PageFactory.initElements(driver, this);
    }

    //Sore all the web elements
    @FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
    WebElement add_cart;
    @FindBy(xpath="//a[@class='shopping_cart_link']")
    WebElement shopping_bag;



    public void clickaddcart() {

        add_cart.click();
    }

    public void shopped_bsg() {

        shopping_bag.click();
    }

}
