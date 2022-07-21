package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class wait {
    private WebDriverWait wait;
    public wait(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void waitForElementAppear(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
