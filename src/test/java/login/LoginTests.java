package login;

import base.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {
    @Test(priority = 1)
    @Parameters({"username","wrongPassword"})
    public void FailLoginTest(String username,String password){
        var loginPage = homePage.loginForm();
        loginPage.login(username, password);
        assertTrue(!loginPage.isLogin(),"Error may be occur! Check screenshots!");
    }
    @Test(priority = 2)
    @Parameters({"username","password"})
    public void SuccessfulLoginTest(String username, String password){
        var loginPage = homePage.loginForm();
        loginPage.login(username, password);
        assertTrue(loginPage.isLogin(),"Login Failed! Check screenshots!");
    }
    @Test(priority = 3)
    public void AddToCart(){
        var resultsSearchPage = homePage.Search("Macbook");
    }
}
