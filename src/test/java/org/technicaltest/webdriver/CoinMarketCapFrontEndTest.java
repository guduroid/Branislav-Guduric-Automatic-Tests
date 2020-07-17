package org.technicaltest.webdriver;

/*
@author Branislav Guduric

In this class are FrontEnd automatic tests for website https://coinmarketcap.com/
Testing include:

1st test:
    - Choosing Top100 cryptocurrencies
    - Verifying that 100 results are displayed

2nd test:
    - Changing filters so no more than 10 results are shown
    - Selecting no more than 5 cryptocurrencies and adding them to Watchlist
    - CLicking on Watchlist tab and checking selected cryptocurrencies
*/

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.technicaltest.pages.CoinMarketCap;

import java.util.concurrent.TimeUnit;

public class CoinMarketCapFrontEndTest
{
    String webdriverSystemAddress = "C:\\Program Files (x86)\\Google\\chromedriver V84.exe";
    String webdriverChromeDriver = "webdriver.chrome.driver";
    String coinMarketCapAddress = "https://coinmarketcap.com/";

    @Test
    public void SrartWebDriverTest_CheckForTop100Currencies()
    {
        System.setProperty(webdriverChromeDriver, webdriverSystemAddress);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(coinMarketCapAddress);

        CoinMarketCap checkForTop100 = new CoinMarketCap(driver);

        checkForTop100.OpenDropDownMenuWithCurrencies();
        checkForTop100.SelectTop100Results();
        checkForTop100.CheckIfThereIs100CurrenciesDisplayed();

        driver.close();
    }

    @Test
    public void StartWebDriverTest_AddAndCheckItemsInWatchlist()
    {
        System.setProperty(webdriverChromeDriver,webdriverSystemAddress);

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,30);

        driver.manage().window().maximize();
        driver.navigate().to(coinMarketCapAddress);

        CoinMarketCap addAndCheckItemsInWatchlist = new CoinMarketCap(driver);

        wait.until(ExpectedConditions.visibilityOfElementLocated(addAndCheckItemsInWatchlist.buttonShowFilters));
        addAndCheckItemsInWatchlist.OpenFiltersPanel();

        wait.until(ExpectedConditions.visibilityOfElementLocated(addAndCheckItemsInWatchlist.buttonPriceFilter));
        addAndCheckItemsInWatchlist.ExpandPriceFilter();

        wait.until(ExpectedConditions.visibilityOfElementLocated(addAndCheckItemsInWatchlist.inputFieldPriceRangeMin));
        addAndCheckItemsInWatchlist.InsertMinInPriceFilter();

        wait.until(ExpectedConditions.visibilityOfElementLocated(addAndCheckItemsInWatchlist.buttonApplyFilters));
        addAndCheckItemsInWatchlist.ClickOnApplyFilterButton();

        // I didn't know how to check when table is refreshed, so I used implicit wait.
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        addAndCheckItemsInWatchlist.AddCurrencyToWatchlist();

        wait.until(ExpectedConditions.visibilityOfElementLocated(addAndCheckItemsInWatchlist.buttonWatchlist));
        addAndCheckItemsInWatchlist.ClickOnWatchlistButton();

        addAndCheckItemsInWatchlist.CheckForWatchlistedCurrencies();

        driver.close();
    }
}