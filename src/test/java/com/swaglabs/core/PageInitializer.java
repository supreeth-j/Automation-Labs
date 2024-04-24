package com.swaglabs.core;

import com.swaglabs.pages.LoginPage;
import com.swaglabs.pages.ProductsPage;
import org.openqa.selenium.WebDriver;

public class PageInitializer  extends BaseClass {
    public static LoginPage loginPage;
    public static ProductsPage productsPage;


    public static void initialize() {

        loginPage = new LoginPage(driver);

        productsPage = new ProductsPage(driver);


    }
}