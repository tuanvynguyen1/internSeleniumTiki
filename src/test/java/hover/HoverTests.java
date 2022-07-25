package hover;

import base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.UserManagerPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTests extends BaseTest {
    @Test(priority = 1)
    @Parameters({"username","password"})
    public void SuccessfulLoginTest(String username, String password){
        var loginPage = homePage.loginForm();
        loginPage.login(username, password);
        assertTrue(loginPage.isLogin(),"Login Failed! Check screenshots!");
    }

    @Test(priority = 2)
    public void testSuccessfullyHoverAccountManager(){
        UserManagerPage userManagerPage = homePage.hoverToUserManager();
        UserManagerPage.AccountControl box = userManagerPage.hoverOnAccount();
        assertTrue(box.isAccountControlDisplayed(), "Box not displayed");
        box.ClickToOpenMyOrder();
        assertEquals(box.getLinkText(),"Đơn hàng của tôi", "Failed!");
    }
}
