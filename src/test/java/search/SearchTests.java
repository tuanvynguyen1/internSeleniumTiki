package search;

import base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Locale;

import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest {
    @Test(dataProvider = "dp")
    public void searchTests(HashMap<String, String> hashMap){
        var resultSearchPage =  homePage.Search(hashMap.get("key"));
        assertTrue(resultSearchPage.getNumProduct()!=0,"Product page not loaded!");
        assertTrue(resultSearchPage.searchTest(hashMap.get("key")),"Search Engine has trouble");
        assertTrue(resultSearchPage.getTitle().toLowerCase().contains(hashMap.get("key").toLowerCase() + " giá siêu tốt"),"Title incorrect");
        System.out.println(resultSearchPage.getID());
    }
}