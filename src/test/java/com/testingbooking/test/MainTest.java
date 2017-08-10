package com.testingbooking.test;
import org.testng.Assert;
import org.testng.annotations.*;
import com.testingbooking.pages.*;


public class MainTest extends BaseTest {

    @Test
    public void checkTheNYCHotelsSearch() {
        //Main test is working now only with September and August values as "month'
        //and New York City as "hotelPlace"
        String month = "September";
        String checkInDate = "20";
        String checkOutDate = "25";
        String hotelPlace = "New York City";

        MainPage mainPage = new MainPage(driver);
        mainPage.visit();
        mainPage = mainPage.closeSigninForm();
        mainPage.checkPageLanguage();
        mainPage.searchThePlace(hotelPlace);
        mainPage.selectCheckInDate(month, checkInDate);
        mainPage.selectCheckOutDate(month, checkOutDate);
        SearchResultsPage searchResultsPage = mainPage.performSearch();

        Assert.assertTrue(searchResultsPage.checkTheHotels(searchResultsPage.getNumberOfHotels()));
    }
}
