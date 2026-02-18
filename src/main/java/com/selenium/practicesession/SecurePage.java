package com.selenium.practicesession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage {
	
	WebDriver driver;
	public SecurePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By successMessage = By.cssSelector("h4.subheader");
	By logoutButton = By.cssSelector("a.button.secondary.radius");
	
	public String getSuccessMessage() {
		return driver.findElement(successMessage).getText();
	}
	
	public void clickLogout() {
		driver.findElement(logoutButton).click();
		
	}

}
