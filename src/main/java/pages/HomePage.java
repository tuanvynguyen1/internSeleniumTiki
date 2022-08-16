package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.*;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    private By searchBox = By.xpath("//input[@data-view-id=\"main_search_form_input\"]");
    private By accountButton = By.xpath("//div[@data-view-id=\"header_header_account_container\"]");
    private By cartIcon = By.xpath("//*[@id=\"main-header\"]/div[1]/div/div[2]/div[2]/a");
    private By ckeckedIcon = By.xpath("//img[@src=\"https://salt.tikicdn.com/ts/upload/d6/21/75/6a9b5426723f04be8f111c1b2afb5af3.png\"]");
    private By checkedIcon = By.xpath("//img[@src=\"https://salt.tikicdn.com/ts/upload/d6/21/75/6a9b5426723f04be8f111c1b2afb5af3.png\"]");
    private By accountContainer = By.xpath("//div[@data-view-id=\"header_header_account_container\"]");
    private By accountInfo = By.xpath("//p[@title=\"Tài khoản của tôi\"]");
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
    public AccountDetailPage toAccountDetailPage(){
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(accountContainer)).perform();
        Wait.waitForElementAppear(driver, accountInfo);
        driver.findElement(accountInfo).click();
        return new AccountDetailPage(driver);
    }
    public ResultsSearchPage Search(String text){
        text = Keys.chord(text, Keys.RETURN);
        driver.findElement(searchBox).sendKeys(text);
        return new ResultsSearchPage(driver);
    }
    public int getNumItemsInCart(){
        return Integer.parseInt(driver.findElement(cartIcon).getText());
    }
    public CartPage toCart(){
        utils.Wait.waitForElementDisappear(driver,checkedIcon);
        driver.findElement(By.xpath("//a[@data-view-id=\"header_user_shortcut_cart\"]")).click();
        return new CartPage(driver);
    }

}
