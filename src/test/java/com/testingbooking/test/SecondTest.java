package com.testingbooking.test;

import com.testingbooking.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SecondTest extends BaseTest {

    @Test
    public void leftTheFeedback() {
        String feedbackRating = "5"; //only values from "1" to "5" is valid
        String feedbackType = "Praise"; //only "Complaint", "Praise" and "Suggestion"
        String feedbackText = "All is ok, guys! :)";


        MainPage mainPage = new MainPage(driver);
        mainPage.visit();
        mainPage = mainPage.closeSigninForm();
        mainPage.checkPageLanguage();

        mainPage.clickCustomerServiceButton();
        mainPage.clickUserFeedbackButton();
        mainPage.leftTheFeedback(feedbackRating, feedbackType, feedbackText);

        Assert.assertTrue(mainPage.isCongratulationsMessagePresented());

    }
}
