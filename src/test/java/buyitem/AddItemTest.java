package buyitem;

import base.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertTrue;

public class AddItemTest extends BaseTest {

    @Test(dataProvider = "dp", description = "Search one item then add it to cart")
    public void addItem(HashMap<String, String> hashMap){
        var loginPage = homePage.loginForm();
        homePage = loginPage.login(username, password);
        var search = homePage.Search(hashMap.get("keyword"));
        var DetailPage = search.addToCart(3);
        DetailPage.addToCart();
    }


}
