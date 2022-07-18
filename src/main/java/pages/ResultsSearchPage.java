package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.regex.Matcher;

import java.time.Duration;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class ResultsSearchPage {
    private WebDriver driver;
    private By productItems = By.xpath("//a[@class=\"product-item\"]");
    private ArrayList<Product> products = new ArrayList<>();
    public ResultsSearchPage(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sort-list")));

        this.driver = driver;
    }
    public int getNumProduct(){
        return driver.findElements(productItems).size();
    }
    public String getName(int index){

        Product p = new Product(driver.findElements(productItems).get(index));
        return p.getName();
    }
    public boolean searchTest(String searchKeys){

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
    public void addToCart(){
        for (WebElement ele: driver.findElements(productItems)
        ) {
            products.add(new Product(ele));
        }
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
    }
}
