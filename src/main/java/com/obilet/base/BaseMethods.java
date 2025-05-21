package com.obilet.base;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

public class BaseMethods{

    public WebDriver driver = Browser.getChromeDriver();
    public final JavascriptExecutor js = (JavascriptExecutor) driver;
    public static Logger Logger = LogManager.getLogger();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void jsClick(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);

            Logger.info("Clicked on element using JavaScript: " + element.toString());
        } catch (Exception e) {
            Logger.error("Error clicking on element using JavaScript: " + element.toString(), e);
            throw e;
        }
    }

    public void waitUntilElementsVisible(List<WebElement> elements) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            for (WebElement element : elements) {
                wait.until(ExpectedConditions.visibilityOf(element));
            }
        } catch (Exception e) {
            Logger.error("Elementler gorunur olana kadar beklenirken hata olustu");
            e.printStackTrace();
        }
    }


    public void Control(boolean statement, String onTrue, String onFalse) {
        if (statement) {
            Logger.info(onTrue);
        } else {
            Logger.error(onFalse);
        }
    }

    public void sendKeyCharacters(WebElement element, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            element.clear();
            element.sendKeys(Keys.BACK_SPACE);

            for (char c : text.toCharArray()) {
                element.sendKeys(String.valueOf(c));
                Thread.sleep(100);
            }

            Logger.info("SendKeys : " + text + " - Element : " + element.getAttribute("value"));
        } catch (Exception e) {
            Logger.error("Hata! - Element: " + element.getAttribute("value"));
            e.printStackTrace();
        }
    }

    public boolean isElementExist(List<WebElement> elem) {

        return isElementExist(elem, 15);
    }

    public boolean isElementExist(List<WebElement> elem, int timeSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeSeconds));
        boolean isExist = !elem.isEmpty();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        return isExist;
    }

    public void waitElementToBeClicked(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getTextOfElement(WebElement elem) {
        String text = null;
        try {
            text = elem.getText();
            //Log.pass(text);
        } catch (Exception exception) {
            //Log.error(new CouldNotGetText(exception));
        }
        return text;
    }

    public String getTitle() {
        return driver.getTitle();
    }
    public void getUrl(String url) {
        driver.get(url);
    }

    public void Wait(int millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String generateRandomEmail() {
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        return "testuser_" + uuid + "@example.com";
    }

    public String generateRandomPassword() {
        return RandomStringUtils.random(4, true, true) + "@" +
                RandomStringUtils.randomNumeric(4) +
                RandomStringUtils.randomAlphabetic(4).toUpperCase();
    }
}
