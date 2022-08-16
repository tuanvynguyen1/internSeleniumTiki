package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.Wait;

public class ResultsSearchPage {
    private WebDriver driver;
    private By productItems = By.xpath("//a[@class=\"product-item\"]");
    private By searchLoc = By.xpath("//div[@class=\"search-summary\"]");
    private ArrayList<Product> products = new ArrayList<>();
    public ResultsSearchPage(WebDriver driver){
        Wait.waitForElementAppear(driver, searchLoc);
        Wait.waitForElementAppear(driver, productItems);
        this.driver = driver;
    }
    public int getNumProduct(){
        return driver.findElements(productItems).size();
    }
    public String getName(int index){

        Product p = new Product(driver.findElements(productItems).get(index));
        return p.getName();
    }
    public boolean isHaveKeyInName(String searchKeys){

        for (WebElement ele: driver.findElements(productItems)
             ) {
            products.add(new Product(ele));
        }
        for (Product p: products
             ) {
            if(p.getName().toLowerCase().contains(searchKeys.toLowerCase())){
                System.out.println("Found: " + p.getName());
                return true;
            }
        }
        return false;
    }

    public DetailProductPage addToCart(int index){
        Product p = new Product(driver.findElements(productItems).get(index));
        p.buy();
        return new DetailProductPage(driver);
    }
    public String getTitle(){
        return driver.getTitle();
    }
    public String getID(){
        return products.get(1).getId();
    }
    public class Product{
        WebElement element;

        public Product(WebElement element){ this.element = element;}
        public String getName(){
            return element.findElement(By.tagName("h3")).getText();
        }
        public String getId(){
            String url =  element.findElement(By.xpath("//a[@class=\"product-item\"]")).getAttribute("href");
            Pattern pattern = Pattern.compile("p\\w+\\.");
            Matcher matcher = pattern.matcher(url);
            if(matcher.find()){
                System.out.println(matcher.group().replace(".",""));
            }
            return "";
        }
        public void buy(){
            element.click();
        }
    }
}
