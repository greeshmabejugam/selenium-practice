package com.selenium.practicesession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecureAreaTest extends BaseTest {

    LoginPage lp;
    SecurePage sp;

    @BeforeMethod
    public void initPages() {
        lp = new LoginPage(driver);
        sp = new SecurePage(driver);
    }

    // keep your @Test exactly as it is

	@Test
	
	public void secureAreaTest() {
		lp.login("tomsmith", "SuperSecretPassword!");
		 test = extent.createTest("Secure Area Test");
		Assert.assertTrue(
			    sp.getSuccessMessage().contains("Welcome to the Secure Area"),
			    "Message not found!"
			);
		
		sp.clickLogout();
	}
		
	@AfterMethod
	public void closeAll() {
		driver.quit();
	}

}
