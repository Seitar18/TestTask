package com.testingbooking.initializations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Alert;


public abstract class Wrappers {

    public abstract WebDriver getWebDriver();

    protected By findByName(String name){
        return By.name(name);
    }

    protected By findByXPath(String xpath){
        return By.xpath(xpath);
    }

    protected void waitUntilElement(By locator){
        new WebDriverWait(getWebDriver(), 15).until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitUntilElementVisible(By locator){
        new WebDriverWait(getWebDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void switchToFrame(By frame){ getWebDriver().switchTo().frame(getWebDriver().findElement(frame)); }

    protected int getCountOfElements(By locator){return getWebDriver().findElements(locator).size();}

    protected void type(By field, String value){
        getWebDriver().findElement(field).sendKeys(value);
    }

    protected void click(By element){
        getWebDriver().findElement(element).click();
        pause(100);
    }

    protected void selectByText(By locator, String text){
        Select select = new Select(getWebDriver().findElement(locator));
        select.selectByVisibleText(text);
    }

    protected String getText(By element){return getWebDriver().findElement(element).getText();}

    protected void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private Boolean isElementExist( By element){return (getWebDriver().findElements(element).size() != 0);}

    protected Boolean isElementPresented(By element){
        Boolean elementCondition = false;
        try{
            waitUntilElement(element);
        }
        catch (Exception e){
            return false;
        }

        if(isElementExist(element))
            elementCondition = getWebDriver().findElement(element).isDisplayed();

        return  elementCondition;
    }

    protected void open(String url){
        getWebDriver().get(url);
    }

}
