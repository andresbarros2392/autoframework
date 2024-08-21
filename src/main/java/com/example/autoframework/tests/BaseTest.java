package com.example.autoframework.tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.example.autoframework.webdrivermanager.WebDriverManager;

import java.awt.font.ImageGraphicAttribute;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        driver = WebDriverManager.getDriver(browser);
        driver.get("https://www.saucedemo.com/"); // Base URL
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result);
        }
        WebDriverManager.quitDriver();
    }

    // Method to capture screenshot
    public void takeScreenshot(ITestResult result) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        // Generate a timestamp to uniquely identify the screenshot file
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());        
        String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");
        String fileName = result.getName() + "_" + browser + "_"+ timestamp + ".png";
        // Set the destination path for the screenshot file
        String filePath = System.getProperty("user.dir") + "/screenshots/" + fileName;
        
        // Save the screenshot
        try {
            FileHandler.createDir(new File(System.getProperty("user.dir") + "/screenshots/"));
            FileHandler.copy(srcFile, new File(filePath));
            System.out.println("Screenshot taken: " + filePath);
            Reporter.log("<a href='"+srcFile.getAbsolutePath()+"'><img src='"+srcFile.getAbsolutePath()+"' height='700' width='700'/></a>");
            result.setAttribute("screenshotPath", filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }
}
