//package com.selenium.practicesession;
//import com.selenium.practicesession.LoginPage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//
//
///**
// * Hello world!
// *
// */
//public class LoginTest
//{
//    public static void main( String[] args )
//    {
//    	
//    	WebDriver driver = new ChromeDriver();
//    	LoginPage lp = new LoginPage(driver);
//    	lp.login("tomsmith", "SuperSecretPassword!");
//    	
//    	
//    	driver.close();
//    	driver.quit();
//
//  
//    }
//}
// The above code is done by us (mrudula & me) - below one is from claude as this is not running it suggested to add @Test

package com.selenium.practicesession;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage lp;

    @BeforeMethod
    public void initPages() {
        lp = new LoginPage(driver);
    }

    // keep your @DataProvider and @Test exactly as they are

//    
//   
    
 // This test verifies successful login
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"tomsmith", "SuperSecretPassword!", true},   // valid - should pass
            {"wronguser", "wrongpassword", false},         // invalid - should fail
            {"tomsmith", "wrongpassword", false},          // wrong password - should fail
        };
    }
 

    @Test(dataProvider = "loginData")
    public void validLoginTest(String username, String password, boolean isValid) {
    	test = extent.createTest("Login Test - " + username); 
        lp.login(username, password);
        if(isValid) {
            Assert.assertTrue(
                lp.getSuccessMessage().contains("You logged into a secure area!"),
                "Valid login failed!"
            );
        } else {
        	Assert.assertTrue(
        		    lp.getErrorMessage().contains("invalid!"),
        		    "Invalid login did not show error!"
        		);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

