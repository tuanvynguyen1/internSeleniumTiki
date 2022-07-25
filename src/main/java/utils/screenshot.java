package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class screenshot {
    public static void takeScreenshotsError(WebDriver driver) throws InterruptedException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String path = "";
        int i=1;
        try{
            path = "screenshots/"+timeStamp;
            Files.createDirectories(Paths.get(path));

        }catch (Exception e){

        }
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
