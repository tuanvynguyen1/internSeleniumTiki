package account;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddressPageTest extends BaseTest {
    @Test
    public void Test(){
        homePage.loginForm().login(username, password);
        var accountDetailPage = homePage.toAccountDetailPage();
        var accountAddressPage= accountDetailPage.toAddressPage();
        assertEquals(accountAddressPage.getTxtTitle(), "Sổ địa chỉ");
    }
}
