package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Wait;
public class DetailProductPage {
    private WebDriver driver;
    private By buyButton = By.xpath("//button[@class=\"btn btn-add-to-cart\"]");
    public DetailProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void addToCart(){
        utils.Wait.waitForElementAppear(driver, buyButton);
        driver.findElement(buyButton).click();

    }
    public boolean getQuantity(){
        WebElement quantityElement = driver.findElement(By.className("qty-and-message"));
        int quantity = Integer.parseInt(quantityElement.findElement(By.xpath("//input[@class=\"input\"]")).getAttribute("value"));
        if(quantity == 1){
            if(quantityElement.findElements(By.className("disable")).size()==0) {
                return false;
            }
        }
        quantityElement.findElement(By.xpath("//img[@alt='add-icon']")).click();
        quantity = Integer.parseInt(quantityElement.findElement(By.xpath("//input[@class=\"input\"]")).getAttribute("value")) - quantity;
        if(quantity != 1) return false;
        return true;
    }
    public boolean followShopTest(){
        utils.Wait.waitForElementAppear(driver, By.className("seller-action"));
        WebElement e =  driver.findElement(By.className("seller-action"));
        if(e.findElements(By.xpath("//div[@class=\"action follow\"]")).size()!=0)
            e.findElements(By.xpath("//div[@class=\"action follow\"]")).get(0).click();
        if(e.findElements(By.xpath("div[@class=\"active action follow\"]")).size()!=0) return true;
        return false;
    }

}
