package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver driver;
    private By byProductLink = By.xpath("//a[@class=\"product__img\" and @data-view-id=\"cart_main_product\"]");
    private By byProduct = By.xpath("//div[contains(@class,  \"NormalProduct\")]");
    private By byQty = By.xpath("//div[@class=\"product-qty\"]");
    private By numQuantity = By.className("qty-input");
    private By addQuantityBtn = By.xpath("//span[@data-view-id=\"cart_main_quantity.increase\"]");
    public CartPage(WebDriver driver){
        utils.Wait.waitForElementAppear(driver, byProduct);
        this.driver = driver;
    }

    public boolean checkQuantity(String id){
        List<WebElement> products = driver.findElements(byProduct);
        for (WebElement p: products) {
            System.out.println(p.findElement(By.className("product__name")).getText());
        }
        return true;
    }

    public Boolean isQuantityUpdate(){

        List<WebElement> products = driver.findElements(byProduct);
        for(WebElement p: products){
            if(addQuantityForElement(p) == false)
                return false;
        }
        return true;
    }
    public Boolean deleteItem(){

        WebElement product = driver.findElement(byProduct);
        product.findElement(By.className("product__delete")).click();
        String linkProduct = product.findElement(By.xpath("//a[@class='product__name']")).getAttribute("href");
        utils.Wait.waitForElementAppear(driver, By.xpath("//div[text()='Xác Nhận']"));
        driver.findElement(By.xpath("//div[text()='Xác Nhận']")).click();
        for (WebElement p:
             driver.findElements(byProduct)) {
            if(linkProduct == product.findElement(By.xpath("//a[@class='product__name']")).getAttribute("href"))
                return false;
        }
        return true;
    }
    private int getQuantityValue(WebElement e){
        return Integer.parseInt(e.findElement(numQuantity).getAttribute("value"));
    }
    private Boolean addQuantityForElement(WebElement e){
        int currQuantity = getQuantityValue(e);

        e.findElement(By.className("qty-increase")).click();
        System.out.println(currQuantity +" " +getQuantityValue(e));
        currQuantity = getQuantityValue(e)- currQuantity;;
        if(currQuantity != 1)
            return false;
        return true;
    }

}
