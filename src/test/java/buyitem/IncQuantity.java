package buyitem;

import base.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertTrue;

public class IncQuantity extends BaseTest {
    @Test(dataProvider = "dp", description = "Increase Quantity of all items in cart")
    public void addQuantity(HashMap<String, String> hashMap){
        var loginPage = homePage.loginForm();
        homePage = loginPage.login(hashMap.get("username"), hashMap.get("password"));
        var cart = homePage.toCart();
        assertTrue(cart.isQuantityUpdate(),"Error in increase Quantity");
    }
    @Test(description = "Delete 1 item in cart")
    public void deleteItem(){
        var cart = homePage.toCart();
        assertTrue(cart.deleteItem(),"Error delete Item");
    }

}
