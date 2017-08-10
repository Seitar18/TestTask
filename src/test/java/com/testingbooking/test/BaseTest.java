package com.testingbooking.test;


import com.testingbooking.initializations.Wrappers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.nio.file.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public abstract class BaseTest extends Wrappers {

    private static String currentDomain = "";

    protected WebDriver driver;

    //Setting chromedriver for Windows. Remember that
    // names of executable drivers files in different OSes are also different
    protected  WebDriver setChromeDriver(){
        String pathToChromeDriver =
                Paths.get("./src/test/resources/ChromeDriver/chromedriver.exe").toAbsolutePath().toString();
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver chromeDriver = new ChromeDriver(options);
        return chromeDriver;
    }

    static public String getCurrentDomain(){
        return currentDomain;
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

    @Parameters({"domain"})
    @BeforeTest
    public void setUpDomain(String domain) { this.currentDomain = domain; }

    @BeforeMethod
    public void setUp(){driver = setChromeDriver(); }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
