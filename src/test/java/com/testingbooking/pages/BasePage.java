package com.testingbooking.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.testingbooking.initializations.Wrappers;
import com.testingbooking.test.BaseTest;


public abstract class BasePage extends Wrappers {

    public static String currentDomain = BaseTest.getCurrentDomain();

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }



}
