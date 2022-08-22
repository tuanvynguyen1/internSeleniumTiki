package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountDetailPage {
    private WebDriver driver;
    private By addresschange = By.xpath("//a[@href=\"/customer/address\"]");
    public AccountDetailPage(WebDriver driver){
        this.driver = driver;
    }
    public AccountAddressPage toAddressPage(){
        utils.Wait.waitForElementAppear(driver, addresschange);
        driver.findElement(addresschange).click();
        return new AccountAddressPage(driver);
    }
}
