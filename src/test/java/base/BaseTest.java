package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;
    private String path;
    private int i = 1;
    @BeforeMethod
    public void rollBack(){
        driver.get("https://tiki.vn/");
        homePage = new HomePage(driver);
    }
    @BeforeClass
    public void setUp(){
        System.setProperty("web-driver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        try{
            path = "screenshots/"+timeStamp;
            Files.createDirectories(Paths.get(path));

        }catch (Exception e){

        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @AfterMethod
    public void takeScreenshots() throws InterruptedException {
        Thread.sleep(300);
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try {

            Files.move(screenshot.toPath(), Paths.get(path+"/screenshot"+i+".png"));
            i++;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
