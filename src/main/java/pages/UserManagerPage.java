package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UserManagerPage {
    private WebDriver driver;

    private By user = By.xpath("//div[@data-view-id='header_header_account_container']");
    private By boxControl = By.xpath("//div[@class='Userstyle__UserDropDown-sc-6e6am-6 embpQf toggler']");

    public UserManagerPage(WebDriver driver) {
        this.driver = driver;
    }

    public AccountControl hoverOnAccount(){
        WebElement figure = driver.findElement(user);

        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();

        return new AccountControl(figure.findElement(boxControl));
    }

    public class AccountControl{
        private WebElement box;

        private By myOrderLink = By.xpath("//a[@href='/sales/order/history?src=header_my_account']");
        public AccountControl(WebElement box) {
            this.box = box;
        }
        public boolean isAccountControlDisplayed(){
            return box.isDisplayed();
        }

        public void ClickToOpenMyOrder(){
            box.findElement(By.xpath("//a[@href='/sales/order/history?src=header_my_account']")).click();
        }


        public String getLinkText(){
            return box.findElement(myOrderLink).getText();
        }
    }
}
