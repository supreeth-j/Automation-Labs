package com.swaglabs.core;

import com.swaglabs.config.ConfigsReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.swaglabs.config.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.time.Duration;

public class BaseClass {
    private static final Logger logger = LogManager.getLogger(BaseClass.class);
    public static WebDriver driver;

    public static WebDriver setUp() {

        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        logger.info("Able to recognize CONFIGURATION_FILEPATH");
        switch (ConfigsReader.getProperty("browser").toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("--headless");  // Enable headless mode
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                logger.info("Able to launch chrome browser ");
                break;

            case "firefox":

                driver = new FirefoxDriver();
                break;

            case "ie":
                driver = new InternetExplorerDriver();
                break;

            default:
                throw new RuntimeException("Browser is not supported!");
        }

        PageInitializer.initialize();
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Able to quit chrome browser");
        }
    }

    public static String launchUrl(String url) {
        driver.get(ConfigsReader.getProperty("url"));
        logger.info("Able to read getProperty url value");
        driver.manage().window().maximize();
        logger.info("Able to maximize window");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
        logger.info("Able to wait for 60 secs");
        return url;
    }

}
