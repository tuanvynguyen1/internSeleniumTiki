package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;
import utils.Account;
import utils.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class BaseTest {

    private ChromeDriver driver;
    protected HomePage homePage;
    protected String username;
    protected String password;
    private String path;
    private int i = 1;
    @BeforeMethod
    public void rollBack(){
        driver.get("https://tiki.vn/");
        homePage = new HomePage(driver);
    }
    @BeforeSuite
    public void setUpAccount(){
        Account a = new Account();
        username = a.getUsername();
        password = a.getPassword();
    }
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().window().maximize();
    }

    @DataProvider(name="dp")
    public Object[][] getDataForTest(){
        try {
            FileReader jsonFile = new FileReader(System.getProperty("user.dir") + "/src/test/java/resources/data.json");
//            Data.getData(this.getClass().getName().replace(".","/"), jsonFile);
            return Data.getData(this.getClass().getName().replace(".","/"), jsonFile);
        }catch(FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
            System.out.println("File not found: " + System.getProperty("user.dir") + "/src/test/java/test/data.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
