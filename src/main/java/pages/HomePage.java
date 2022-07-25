package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    private By searchBox = By.xpath("//input[@data-view-id=\"main_search_form_input\"]");
    private By accountButton = By.xpath("//div[@data-view-id=\"header_header_account_container\"]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void clickElement(By element){
        driver.findElement(element).click();
    }
    public LoginPage loginForm(){
        clickElement(accountButton);
        return new LoginPage(driver);
    }
    public UserManagerPage hoverToUserManager(){
        return new UserManagerPage(driver);
    }
    public ResultsSearchPage Search(String text){
        text = Keys.chord(text, Keys.RETURN);
        driver.findElement(searchBox).sendKeys(text);

        return new ResultsSearchPage(driver);
    }
}
