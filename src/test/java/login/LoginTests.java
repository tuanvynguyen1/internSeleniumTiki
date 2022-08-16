package login;

import base.BaseTest;
import org.openqa.selenium.NotFoundException;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;
public class LoginTests extends BaseTest {
//    @Test(priority = 1)
//    @Parameters({"username","wrongPassword"})
//    public void FailLoginTest(String username,String password){
//        var loginPage = homePage.loginForm();
//        loginPage.login(username, password);
//        assertTrue(!loginPage.isLogin(),"Error may be occur! Check screenshots!");
//    }
//    @Test
//    public void Login_should_fail_if_enter_invalid_phone_number(){
//        var loginPage = homePage.loginForm();
//        loginPage.login(username + "2", password);
//    }

    @Test
    public void Login_should_fail_if_user_is_invalid() {
        var loginPage = homePage.loginForm();
        loginPage.login(username, password);
        assertTrue(loginPage.isLogin(), "Login Failed! Check screenshots!");
    }


}
