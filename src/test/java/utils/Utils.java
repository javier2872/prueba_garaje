package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    /**
     * to wait clickable an element
     *
     * @param aElement
     * @param aDriver
     */
    public static void waitClickable(WebElement aElement, WebDriver aDriver) {
        WebDriverWait wait = new WebDriverWait(aDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(aElement));
    }

    /**
     * to wait to an element
     *
     * @param aElement
     * @param aDriver
     */
    public static void waitVisibility(By aElement, WebDriver aDriver) {
        WebDriverWait wait = new WebDriverWait(aDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(aElement));
    }
}
