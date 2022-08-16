package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;//img[@class=\"cart-icon\"]
import java.util.concurrent.locks.Condition;

public class Wait {
    private static WebDriverWait wait;

    private static WebDriverWait init(WebDriver wait){
        return new WebDriverWait(wait, Duration.ofSeconds(30));
    }
    public static final void waitForElementAppear(WebDriver driver,By element){
        init(driver).until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public static final void waitForElementDisappear(WebDriver driver, By element){
        init(driver).until(ExpectedConditions.invisibilityOfElementLocated(element));
    }
    public static final void implicitWait(WebDriver driver, int second){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    }
    public static final void waitUntilClickable(WebDriver driver, By element){
        init(driver).until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitForOrExpectedConditions(WebDriver driver, ExpectedCondition[] s){
        init(driver).until(ExpectedConditions.or(s));
    }
}
