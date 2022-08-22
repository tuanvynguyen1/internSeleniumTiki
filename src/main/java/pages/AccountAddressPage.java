package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountAddressPage {
    private WebDriver driver;
    private By addAddressBtn = By.xpath("//a[@ref=\"/customer/address/create\"]");
    private By formControl = By.xpath("//div[@class=\"form-control\"]");
    private By txtTitle = By.xpath("//div[@class=\"heading\"]");
    private By txtPhone = By.xpath("//div[@class=\"phone\"]");
    public AccountAddressPage(WebDriver driver){
        this.driver = driver;
    }

    private void addAddressBtnClick(){
        driver.findElement(addAddressBtn).click();
    }
    public String getTxtTitle(){
        utils.Wait.waitForElementAppear(driver, txtPhone);
        return driver.findElement(txtTitle).getText();
    }
    public void addAddress(String hoten, String company, String phonenumber, String city, String district,String wards){
        List<WebElement> form = driver.findElements(formControl);
        for (WebElement e:
             form) {

        }
    }
}
