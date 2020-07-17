package org.technicaltest.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.technicaltest.pages.CoinMarketCap;

public class CoinMarketCapFrontEndTest
{

    String webdriverSystemAddress = "C:\\Program Files (x86)\\Google\\chromedriver V84.exe";
    String webdriverChromeDriver = "webdriver.chrome.driver";
    String coinMarketCapAddress = "https://coinmarketcap.com/";

    @Test
    public void SrartWebDriverTest_CheckForTop100Currencies()
    {
        //System.setProperty(webdriverChromeDriver, webdriverSystemAddress);
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\chromedriver V84.exe");
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

        driver.manage().window().maximize();
        driver.navigate().to(coinMarketCapAddress);

        CoinMarketCap addAndCheckItemsInWatchlist = new CoinMarketCap(driver);

        addAndCheckItemsInWatchlist.OpenFiltersPanel();
        addAndCheckItemsInWatchlist.ExpandPriceFilter();
        addAndCheckItemsInWatchlist.InsertMinInPriceFilter();
        addAndCheckItemsInWatchlist.ClickOnApplyFilterButton();
        addAndCheckItemsInWatchlist.AddCurrencyToWatchlist();
        addAndCheckItemsInWatchlist.ClickOnWatchlistButton();
        addAndCheckItemsInWatchlist.CheckForWatchlistedCurrencies();
    }
}
