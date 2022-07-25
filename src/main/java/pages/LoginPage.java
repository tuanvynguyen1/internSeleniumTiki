package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private By inputUsername = By.xpath("//input[@type=\"tel\"]");
    private By inputPassword = By.xpath("//input[@type=\"password\"]");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void login(String username, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputUsername));
        inputElement(inputUsername,username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        inputElement(inputPassword, password);

    }

    private void inputElement(By ele, String text){
        text = Keys.chord(text+Keys.RETURN);
        driver.findElement(ele).sendKeys(text);
    }
    public boolean isLogin(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"input input-error\"]")),
                ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class=\"ReactModalPortal\"]"))));
        if(driver.manage().getCookieNamed("TIKI_USER") != null){
            System.out.println("TOKEN = " +driver.manage().getCookieNamed("TIKI_USER"));
            return true;
        }
        return false;
    }
    public void clickElement(By ele){
        driver.findElement(ele).click();
    }
}
