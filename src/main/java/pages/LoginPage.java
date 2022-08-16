package pages;

import org.junit.internal.runners.statements.ExpectException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private By inputUsername = By.xpath("//input[@type=\"tel\"]");
    private By inputPassword = By.xpath("//input[@type=\"password\"]");
    private By ckeckedIcon = By.xpath("//img[@src=\"https://salt.tikicdn.com/ts/upload/d6/21/75/6a9b5426723f04be8f111c1b2afb5af3.png\"]");
    private By loginButotn = By.xpath("//span[text()=\"Đăng Nhập / Đăng Ký\"]");
    private By inputError = By.xpath("//div[@class=\"input input-error\"]");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public HomePage login(String username, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        utils.Wait.waitForElementAppear(driver ,inputUsername);
        inputElement(inputUsername,username);
        utils.Wait.waitForElementAppear(driver, inputPassword);
        inputElement(inputPassword, password);
        utils.Wait.waitForOrExpectedConditions(driver, new ExpectedCondition[]{ExpectedConditions.visibilityOfElementLocated(inputError),
                ExpectedConditions.visibilityOfElementLocated(ckeckedIcon)});
        return new HomePage(driver);
    }

    private void inputElement(By ele, String text){
        text = Keys.chord(text+Keys.RETURN);
        driver.findElement(ele).sendKeys(text);
    }
    public boolean isLogin(){


        if(driver.findElements(loginButotn).size() == 0){
            return true;
        }
        return false;
    }
    public void clickElement(By ele){
        driver.findElement(ele).click();
    }
}
