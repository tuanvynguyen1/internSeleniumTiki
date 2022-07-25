package login;

import base.BaseTest;
import org.testng.annotations.DataProvider;
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
<<<<<<< HEAD
    @Test(dataProvider = "getDataForTest")
=======
    @Test(priority = 2)
>>>>>>> f229de5cc531b323b2eecde91fe24adffb10e801
    @Parameters({"username","password"})
    public void SuccessfulLoginTest(String username, String password){
        var loginPage = homePage.loginForm();
        loginPage.login(username, password);
        assertTrue(loginPage.isLogin(),"Login Failed! Check screenshots!");
    }
<<<<<<< HEAD

=======
    @Test(priority = 3)
    public void AddToCart(){
        var resultsSearchPage = homePage.Search("Macbook");
    }
>>>>>>> f229de5cc531b323b2eecde91fe24adffb10e801
}
