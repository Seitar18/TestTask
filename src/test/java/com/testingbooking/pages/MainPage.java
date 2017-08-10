package com.testingbooking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class MainPage extends BasePage{

    private By languageButton = findByXPath("//*[contains(@class,'popover_trigger')]/img");
    private By languageSwitchButton = findByXPath("(//*[@class='lang_en-us'])[1]");
    private By searchPlaceField = findByXPath("(//input[@type='search'])[1]");
    private By newYorkResult = findByXPath("//li[@data-label='New York City, New York State, United States of America']");
    private By checkinCalendarButton = findByXPath("//*[@data-placeholder='Check-in Date']");
    private By checkoutCalendarButton = findByXPath("(//*[@data-placeholder='Check-out Date'])[1]");
    private By searchButton =
            findByXPath("//div[@class='sb-searchbox__row u-clearfix sb-searchbox__footer -last']//span[text()='Search']");
    private By closeButton = findByXPath("//*[@class = 'header-signin-prompt']//*[@data-command='noop']");

    private By customerServiceButton = findByXPath("//a[@aria-label='Get customer service help here!']");
    private By feedbackButton = findByXPath("//a[text()='Give website feedback']");
    private By feedbackFrame = findByXPath("//iframe[@title='Usabilla Feedback Form Frame']");
    private By feedbackTypeDropdown = findByName("feedback_type");
    private By feedbackTextField = findByName("feedback");
    private By submitFeedbackButton = findByXPath("//button[text()='Submit']");
    private By congratulationsMessage = findByXPath("//*[@class='feedback']/h2[text()='Thanks for your time!']");

    public MainPage(WebDriver driver){super(driver);}

    public void visit(){ open(currentDomain); }

    //This method switch page language to English(US) if default language is another
    public MainPage checkPageLanguage(){
        waitUntilElementVisible(languageButton);
        if(getText(languageButton).equals("English (US)")){
            return new MainPage(driver);
        }
        else{
            click(languageButton);
            pause(300);
            click(languageSwitchButton);
            return new MainPage(driver);
        }
    }

    public MainPage closeSigninForm() {
        waitUntilElement(closeButton);
        click(closeButton);
        return new MainPage(driver);
    }

    public MainPage searchThePlace(String searchString) {
        type(searchPlaceField, searchString);
        waitUntilElementVisible(newYorkResult);
        click(newYorkResult);
        return new MainPage(driver);
    }

    public MainPage selectCheckInDate(String month, String day){
        waitUntilElementVisible(checkinCalendarButton);
        click(checkinCalendarButton);
        click(checkinCalendarButton);
        waitUntilElementVisible(findByXPath("(//th[contains(text(),'" + month +
                " 2017')]/ancestor::table[@class='c2-month-table']//span[text()='" + day + "'])[1]"));
        click(findByXPath("(//th[contains(text(),'" + month +
                " 2017')]/ancestor::table[@class='c2-month-table']//span[text()='" + day +"'])[1]"));

        return new MainPage(driver);
    }

    public MainPage selectCheckOutDate(String month, String day){
        waitUntilElementVisible(checkoutCalendarButton);
        click(checkoutCalendarButton);
        waitUntilElementVisible(findByXPath("(//th[contains(text(),'" + month +
                " 2017')]/ancestor::table[@class='c2-month-table']//span[text()='" + day +"'])[2]"));
        click(findByXPath("(//th[contains(text(),'" + month +
                " 2017')]/ancestor::table[@class='c2-month-table']//span[text()='" + day + "'])[2]"));

        return new MainPage(driver);
    }

    public SearchResultsPage performSearch(){
        click(searchButton);

        return new SearchResultsPage(driver);
    }

    public void clickCustomerServiceButton(){
        waitUntilElementVisible(customerServiceButton);
        click(customerServiceButton);
    }

    public MainPage clickUserFeedbackButton(){
        waitUntilElementVisible(feedbackButton);
        click(feedbackButton);

        return new MainPage(driver);
    }

    public MainPage leftTheFeedback(String starRating, String feedbackType, String feedbackText){
        waitUntilElementVisible(feedbackFrame);
        switchToFrame(feedbackFrame);

        waitUntilElementVisible(findByXPath("//ul[@class='rating']//label[text()='"+ starRating + "']"));
        click(findByXPath("//ul[@class='rating']//label[text()='"+ starRating + "']"));

        waitUntilElementVisible(feedbackTypeDropdown);

        type(feedbackTextField, feedbackText);
        selectByText(feedbackTypeDropdown, feedbackType);

        click(submitFeedbackButton);

        return new MainPage(driver);
    }

    public Boolean isCongratulationsMessagePresented(){
        waitUntilElementVisible(congratulationsMessage);
        return isElementPresented(congratulationsMessage);
    }
}
