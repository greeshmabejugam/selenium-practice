package com.selenium.practicesession;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By successMessage = By.id("flash");
	By errorMessage = By.id("flash");
	
	public String getSuccessMessage() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
	    return driver.findElement(successMessage).getText();
	}


	public String getErrorMessage() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
	    return driver.findElement(errorMessage).getText();
	}
	
		public void enterUrl() {
			driver.get("https://the-internet.herokuapp.com/login");
			String title = driver.getTitle();
			System.out.println("The title of the page is" + title);
		}
	
    	By username =By.id("username"); 
    	public void enterUsername(String user) {
    		driver.findElement(username).clear();
        	driver.findElement(username).sendKeys(user);
        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	}
    	
    	By pwd1 = By.id("password");
    	public void enterPassword(String pwd) {
    	    driver.findElement(pwd1).clear();
    	    driver.findElement(pwd1).sendKeys(pwd); // ← use the parameter!
    	}
    	By xpath1 = By.xpath("/html/body/div[2]/div/div/form/button/i");
    	public void clickLogin() {
    		driver.findElement(xpath1).click();
    	}
    	
    	public void login(String user, String pwd) {
    		enterUrl();
    		enterUsername(user);
    		enterPassword(pwd);
    		clickLogin();
    		
    	}
  
		
//    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	
    	

    	
		
		
	}
	


