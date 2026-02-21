package com.selenium.practicesession;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecurePage {
	
	WebDriver driver;
	public SecurePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By successMessage = By.cssSelector("h4.subheader");
	By logoutButton = By.cssSelector("a.button.secondary.radius");
	
	public String getSuccessMessage() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
	    return driver.findElement(successMessage).getText();
	}
	
	public void clickLogout() {
		driver.findElement(logoutButton).click();
		
	}

}
