package com.testingbooking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class SearchResultsPage extends BasePage{

    private String hotelAddressLink = "(//*[@id='hotellist_inner']//div[@data-hotelid]//div[@class='address']/a[@title])";
    private By hotelsBlockLocator = findByXPath("//*[@id='hotellist_inner']//div[@data-hotelid]");


    public SearchResultsPage(WebDriver driver){super(driver);}


    //This method switch page language to English(US) if default language is another
    public int getNumberOfHotels(){ return getCountOfElements(hotelsBlockLocator); }

    private By prettyAddressLocatorConverter(int linkNumber){
        return findByXPath(hotelAddressLink + "[" + Integer.toString(linkNumber) + "]");
    }

    public Boolean checkTheHotels(int hotelsNumber) {
        for(int i = 1; i<=hotelsNumber; i++){
            if(!(getText(prettyAddressLocatorConverter(i)).contains("New York City"))){
                return false;
            }
        }
        return true;
    }

}
