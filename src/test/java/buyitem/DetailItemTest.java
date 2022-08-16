package buyitem;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DetailProductPage;

import java.util.HashMap;

import static org.testng.Assert.assertTrue;

public class DetailItemTest extends BaseTest {
    DetailProductPage detailProductPage = null;
    @Test(dataProvider = "dp",description = "Test Description Page")
    public void DetailPageTest(HashMap<String, String> hashMap){
        var loginPage = homePage.loginForm();
        homePage = loginPage.login(hashMap.get("username"), hashMap.get("password"));
        var resultsSearchPage = homePage.Search("Máy hút bụi");
        detailProductPage = resultsSearchPage.addToCart(4);
//        assertTrue(detailProductPage.quantityTest(),"Error in change Quantity");
//        assertTrue(detailProductPage.followShopTest(),"Error follow shop");
    }
}
