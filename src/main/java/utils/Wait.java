package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class wait {
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
}
