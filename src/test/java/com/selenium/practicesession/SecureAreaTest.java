package com.selenium.practicesession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecureAreaTest {
	WebDriver driver;
	LoginPage lp;
	SecurePage sp;
	
	@BeforeMethod
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
		sp = new SecurePage(driver);
		
	}
	
	@Test
	
	public void secureAreaTest() {
		lp.login("tomsmith", "SuperSecretPassword!");
		
		Assert.assertTrue(
				sp.getSuccessMessage().contains("Welcome to the Secure Area. When you are done click logout below."),"Message not found!");
		
		sp.clickLogout();
	}
		
	@AfterMethod
	public void closeAll() {
		driver.quit();
	}

}
