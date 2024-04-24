package com.swaglabs.utils;
import com.swaglabs.config.Constants;
import com.swaglabs.core.PageInitializer;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class CommonUtils extends PageInitializer {

    /**
     * This method clears the textbox and sends another text
     *
     * @param element
     * @param text
     */
    private static final Logger logger = LogManager.getLogger(CommonUtils.class);
    private WebDriverWait wait;
    public static void enterText(WebElement element, String text) {
        try {
            if (text != null && !text.isEmpty()) {
                element.clear();
                element.sendKeys(text);
                logger.info("Entered text '" + text + "' into the element: " + element);
            } else {
                logger.warn("Input text is null or empty. No action performed.");
            }
        } catch (StaleElementReferenceException e) {
            logger.error("StaleElementReferenceException occurred while entering text: " + e.getMessage());
            // You can choose to handle this exception or rethrow it
        } catch (Exception e) {
            logger.error("An error occurred while entering text: " + e.getMessage());
            // You can choose to handle this exception or rethrow it
        }
    }
    /**
     * This method checks if radio/checkbox is enabled and then clicks on the
     * element that has the value we want
     *
     *
     * @param listElement
     * @param value
     */
    public static void clickRadioOrCheckbox(List<WebElement> listElement, String value) {
        String actualValue;

        for (WebElement el : listElement) {
            actualValue = el.getAttribute("value").trim();
            if (el.isEnabled() && actualValue.equals(value)) {
                el.click();
                logger.info("Clicked radio button or checkbox...");
                break; // Add a break statement to exit the loop after clicking
            }
        }
    }
    /**
     * This method checks if the text is found in the dropdown element and only then
     * it selects it
     *
     * @param element
     * @param textToSelect
     */
    public static void selectDropdown(WebElement element, String textToSelect) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(textToSelect);
            logger.info("Selected dropdown option: " + textToSelect);
        } catch (NoSuchElementException e) {
            logger.error("Option '" + textToSelect + "' not found in the dropdown: " + e.getMessage());
        } catch (StaleElementReferenceException e) {
            logger.error("Dropdown element became stale: " + e.getMessage());
        }
    }

    /**
     * This method checks if the index is valid and only then selects it
     *
     * @param element
     * @param index
     */
    public static void selectDropdownByIndex(WebElement element, int index) {
        try {
            Select select = new Select(element);
            int size = select.getOptions().size();
            if (index >= 0 && index < size) {
                select.selectByIndex(index);
                logger.info("Selected dropdown option at index: " + index);
            } else {
                logger.error("Index " + index + " is out of bounds for the dropdown");
            }
        } catch (UnexpectedTagNameException e) {
            logger.error("UnexpectedTagNameException: " + e.getMessage());
        }
    }

    /**
     * This method accepts alerts and catches exception if alert in not present
     *
     */
    /**
     * This method returns the alert text. If no alert is present exception is
     * caught and null is returned.
     *
     * @return
     */
    public static String getAlertText() {
        String alertText = null;
        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            logger.info("Retrieved alert text: " + alertText);
        } catch (NoAlertPresentException e) {
            logger.error("No alert was present: " + e.getMessage());
        }
        return alertText;
    }

    /**
     * This method send text to the alert. NoAlertPresentException is handled.
     *
     * @param text
     */
    public static void sendAlertText(String text) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(text);
            logger.info("Sent text '" + text + "' to the alert");
        } catch (NoAlertPresentException e) {
            logger.error("No alert was present: " + e.getMessage());
        }
    }

    /**
     * This method switches to a frame by using name or id
     *
     * @param nameOrId
     */
    public static void switchToFrame(String nameOrId) {
        try {
            driver.switchTo().frame(nameOrId);
            logger.info("Switched to frame by name or ID: " + nameOrId);
        } catch (NoSuchFrameException e) {
            logger.error("Frame with name or ID '" + nameOrId + "' not found: " + e.getMessage());
        }
    }

    /**
     * This method switches to a frame by using an index
     *
     * @param index
     */
    public static void switchToFrame(int index) {
        try {
            driver.switchTo().frame(index);
            logger.info("Switched to frame by index: " + index);
        } catch (NoSuchFrameException e) {
            logger.error("Frame with index '" + index + "' not found: " + e.getMessage());
        }
    }

    /**
     * This method switches to a frame by using a WebElement
     *
     * @param element
     */
    public static void switchToFrame(WebElement element) {
        try {
            driver.switchTo().frame(element);
            logger.info("Switched to frame using WebElement: " + element);
        } catch (NoSuchFrameException e) {
            logger.error("Frame represented by WebElement was not found: " + e.getMessage());
        }
    }

    /**
     * This method switches focus to a child window
     *
     */
    public static void switchToChildWindow() {
        try {
            String parentWindow = driver.getWindowHandle();
            Set<String> windows = driver.getWindowHandles();

            for (String window : windows) {
                if (!window.equals(parentWindow)) {
                    driver.switchTo().window(window);
                    logger.info("Switched to child window: " + window);
                    break; // Ensure we only switch to the first child window
                }
            }
        } catch (NoSuchWindowException e) {
            logger.error("Child window was not found: " + e.getMessage());
        }
    }

    /**
     * This method click in an element
     *
     * @param element
     */
    public static void click(WebElement element) {
        try {
            element.click();
            logger.info("Clicked element: " + element);
        } catch (ElementNotInteractableException e) {
            logger.error("Unable to click element: " + e.getMessage());
        }
    }


    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Waited for element...");
    }
    /**
     * This methods casts the driver to a JavascriptExecutor and returns it
     *
     * @return
     */
    public static JavascriptExecutor getJSObject() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            logger.info("Obtained JavaScriptExecutor object");
            return js;
        } catch (ClassCastException e) {
            logger.error("Failed to obtain JavaScriptExecutor object: " + e.getMessage());
            return null; // Return null or throw an exception, depending on your error handling strategy
        }
    }

    /**
     * This method will click in the element passed to it using JavascriptExecutor
     *
     * @param element
     */
    public static void jsClick(WebElement element) {
        try {
            getJSObject().executeScript("arguments[0].click()", element);
            logger.info("Clicked element using JavaScriptExecutor: " + element);
        } catch (WebDriverException e) {
            logger.error("Failed to click element using JavaScriptExecutor: " + e.getMessage());
        }
    }

    /**
     * This method will scroll the page until the element passed to it becomes
     * visible
     *
     * @param element
     */
//    public static void scrollToElement(WebElement element) {
//        getJSObject().executeScript("arguments[0].scrollIntoView(true)", element);
//        logger.info("Scrolled to element...");
//    }
    /**
     * This method will scroll the page down based on the passed pixel parameter
     *
     * @param pixel
     */
    public static void scrollDown(int pixels) {
        try {
            getJSObject().executeScript("window.scrollBy(0," + pixels + ")");
            logger.info("Scrolled down by " + pixels + " pixels");
        } catch (WebDriverException e) {
            logger.error("Failed to scroll down: " + e.getMessage());
        }
    }


    public void zoomBy100percentage() {
        try {
            getJSObject().executeScript("document.body.style.zoom='100%'");
            logger.info("Zoomed the screen to 100%");
        } catch (WebDriverException e) {
            logger.error("Failed to set zoom level to 100%: " + e.getMessage());
        }
    }


    public void zoomInByPercentage() {
        try {
            getJSObject().executeScript("document.body.style.zoom='40%'");
            logger.info("Zoomed in the screen to 40%");
        } catch (WebDriverException e) {
            logger.error("Failed to set zoom level to 40%: " + e.getMessage());
        }
    }

    public void scrollUpByPixel() {
        try {
            getJSObject().executeScript("window.scrollBy(0, -1500)");
            logger.info("Scrolled up by 1500 pixels");
        } catch (WebDriverException e) {
            logger.error("Failed to scroll up: " + e.getMessage());
        }
    }


    public void scrollDownByPixel() {
        try {
            getJSObject().executeScript("window.scrollBy(0, 1500)");
            logger.info("Scrolled down by 1500 pixels");
        } catch (WebDriverException e) {
            logger.error("Failed to scroll down: " + e.getMessage());
        }
    }


    public void scrollIntoView(WebElement element) {
        try {
            getJSObject().executeScript("arguments[0].scrollIntoView()", element);
            logger.info("Scrolled element into view: " + element);
        } catch (WebDriverException e) {
            logger.error("Failed to scroll element into view: " + e.getMessage());
        }
    }

    /**
     * This method will scroll the page up based on the passed pixel parameter
     *
     * @param pixel
     */
    public static void scrollUp(int pixels) {
        try {
            getJSObject().executeScript("window.scrollBy(0, -" + pixels + ")");
            logger.info("Scrolled up by " + pixels + " pixels");
        } catch (WebDriverException e) {
            logger.error("Failed to scroll up: " + e.getMessage());
        }
    }



    /**
     * This method will select a date from the calendar
     *
     * @param elements
     * @param text
     */
    public static void selectCalendarDate(List<WebElement> elements, String text) {
        boolean dateFound = false;
        for (WebElement day : elements) {
            if (day.isEnabled() && day.getText().equals(text)) {
                day.click();
                dateFound = true;
                logger.info("Selected calendar date: " + text);
                break;
            }
        }

        if (!dateFound) {
            logger.error("Failed to find and select calendar date: " + text);
            // You can throw an exception or handle this situation based on your error handling strategy.
        }
    }


    /**
     * Method to return the current time stamp in a String
     *
     * @return
     */
    public static String getTimeStamp() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        logger.info("Get time stamp...");
        return simpleDateFormat.format(date.getTime());

    }
    /**
     * Method to get title of the web page
     *
     * @return
     */
    public String getPageTitle() {
        try {
            String pageTitle = driver.getTitle();
            logger.info("Page title: " + pageTitle);
            return pageTitle;
        } catch (WebDriverException e) {
            logger.error("Error while retrieving page title: " + e.getMessage());
            return null; // You might return a meaningful default value or handle this as needed
        }
    }


    /**
     * Sample action code
     */
    public void pressEnter() {
        try {
            Thread.sleep(5000l);
            Actions ac = new Actions(driver);
            ac.sendKeys(Keys.ENTER).perform();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        logger.info("Hit enter key...");
    }

    public void scrollToElement(WebElement element) {
        try {
            int x = element.getLocation().x;
            int y = element.getLocation().y;
            getJSObject().executeScript("window.scrollTo(arguments[0],arguments[1])", x, y);
            logger.info("Scrolled to element: " + element);
        } catch (WebDriverException e) {
            logger.error("Failed to scroll to element: " + e.getMessage());
        }
    }

//    public void scrollToElemetAndClick(WebElement element) {
//        scrollToElemet(element);
//        element.click();
//        logger.info("Scrolled to element and clicked...");
//    }

    public void goBack() {
        driver.navigate().back();
        logger.info("Navigated back...");
    }
    public void goForward() {
        driver.navigate().forward();
        logger.info("Navigated forword...");
    }
    public void refresh() {
        driver.navigate().refresh();
        logger.info("Browser refreshed...");
    }
    /**
     * helper method to wait for element
     *
     * @param ele - WebElement
     * @return - boolean
     */
    public boolean waitForElement(WebElement ele) {
        logger.info("Waiting for element...");
        return wait.until(ExpectedConditions.elementToBeClickable(ele)) != null;
    }


    public static byte[] takeScreenshot(String filename) {
        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

            byte[] picBytes = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

            // Generate a safe destination filename
            String timestamp = getTimeStamp();
            String safeFilename = filename.replaceAll("[^a-zA-Z0-9.-]", "_");
            String destination = Constants.SCREENSHOT_FILEPATH + safeFilename + timestamp + ".png";

            FileUtils.copyFile(sourceFile, new File(destination));
            logger.info("Taken screenshot and saved as: " + destination);
            return picBytes;
        } catch (IOException e) {
            logger.error("Error while taking screenshot: " + e.getMessage());
            e.printStackTrace();
            return null;

        }
    }
}




