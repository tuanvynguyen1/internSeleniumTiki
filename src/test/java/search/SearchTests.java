package search;

import base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;
import java.util.Locale;

import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTest {
    @Test
    @Parameters({"keyword"})
    public void searchTests(String key){
        var resultSearchPage =  homePage.Search(key);
        resultSearchPage.getName(1);
        assertTrue(resultSearchPage.getNumProduct()!=0,"Product page not loaded!");
        assertTrue(resultSearchPage.searchTest(key),"Search Engine has trouble");
        assertTrue(resultSearchPage.getTitle().toLowerCase().contains(key.toLowerCase() + " giá siêu tốt"),"Title incorrect");
    }
}