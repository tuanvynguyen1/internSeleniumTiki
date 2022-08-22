package testCode;

import base.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;

public class testCode extends BaseTest {
    @Test(dataProvider = "dp")
    public void Test(HashMap<String, String> hashMap){
        System.out.println(hashMap.get("username")+"11");
    }
}
