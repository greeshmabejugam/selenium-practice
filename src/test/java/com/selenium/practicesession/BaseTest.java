package com.selenium.practicesession;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

    WebDriver driver;
    static ExtentReports extent;
    static ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        if(System.getenv("CI") != null) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
            
            try {
                File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                String testName = result.getName();
                FileUtils.copyFile(screenshot, 
                    new File("target/screenshots/" + testName + ".png"));
                test.addScreenCaptureFromPath("target/screenshots/" + testName + ".png");
                System.out.println("Screenshot saved for: " + testName);
            } catch(IOException e) {
                System.out.println("Screenshot failed: " + e.getMessage());
            }
        } else if(result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed!");
        } else {
            test.skip("Test skipped!");
        }
        if(driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}