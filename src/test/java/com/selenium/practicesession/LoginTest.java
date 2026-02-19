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

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;
    LoginPage lp;
    
    @BeforeMethod
    public void setup() {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless");
    	options.addArguments("--no-sandbox");
    	options.addArguments("--disable-dev-shm-usage");
    	driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        lp = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() {
        lp.login("tomsmith", "SuperSecretPassword!");
        System.out.println("Login successful!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

