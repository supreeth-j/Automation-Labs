package com.swaglabs.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.swaglabs.core.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.swaglabs.core.BaseClass.driver;

public class Hooks {
    @Before
    public void start()
    {

        BaseClass.setUp();
        System.out.println("started");
    }

    @AfterStep
    public static void takeScreenshots(Scenario scenario) {

        final byte [] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");
    }

    @After
    public void stop() {

        BaseClass.tearDown();
    }
}
