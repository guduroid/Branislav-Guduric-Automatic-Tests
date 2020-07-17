package org.technicaltest.pages;
/*
@author Branislav Guduric

In this class are variables and methods for FrontEnd automatic tests for website https://coinmarketcap.com/

*/

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CoinMarketCap
{
    WebDriver driver;

    // ####################################################
    //VARIABLES FOR FIRST PART OF FE TEST
    // ####################################################

    By dropDownMenuWithCurrencies =  By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/div");
    By top100CurrenciesFromDropDownMenu = By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/div/div[2]/ul/li[2]");
    By listOfTop100Currencies = By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/div/table/tbody");

    // ####################################################
    //VARIABLES FOR SECOND PART OF FE TEST
    // ####################################################

    public By buttonShowFilters = By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/button");
    public By buttonPriceFilter = By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]/div/div/div/button");
    public By inputFieldPriceRangeMin = By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/div[1]/input");
    public By inputFieldPriceRangeMax = By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div[1]/div[3]/input");
    public By buttonApplyFilters = By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/button[2]");
    public By buttonWatchlist = By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div/div[1]/div[2]/ul[1]/li[3]/a");
    public By listOfCurrenciesOnWatchlist = By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div[2]/div/div/ul");

    //By buttonOpenOptionsMenuForSelectedCurrency_01 = By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div/div[2]/div[3]/div/table/tbody/tr[1]/td[9]/div/div");
    //By buttonOpenOptionsMenuForSelectedCurrency_02 = By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div/div[2]/div[3]/div/table/tbody/tr[2]/td[9]/div/div");
    //By buttonOpenOptionsMenuForSelectedCurrency_03 = By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div/div[2]/div[3]/div/table/tbody/tr[3]/td[9]/div/div");
    //By buttonOpenOptionsMenuForSelectedCurrency_04 = By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div/div[2]/div[3]/div/table/tbody/tr[4]/td[9]/div/div");
    //By buttonOpenOptionsMenuForSelectedCurrency_05 = By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div/div[2]/div[3]/div/table/tbody/tr[5]/td[9]/div/div");

    public By[] buttonOpenOptionsMenuForSelectedCurrency = {
            By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[3]/div/table/tbody/tr[1]/td[9]"),   //0
            By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[9]"),   //1
            By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[3]/div/table/tbody/tr[3]/td[9]"),   //2
            By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[3]/div/table/tbody/tr[4]/td[9]"),   //3
            By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[3]/div/table/tbody/tr[5]/td[9]")};  //4
//*[@id="__next"]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[3]/div/table/tbody/tr[5]/td[9]/div/div

    public By[] buttonAddCurrencyToWatchlist = {
            By.xpath("/html/body/div/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[3]/div/table/tbody/tr[1]/td[9]/div/div/div[2]/ul/li[1]"),
            By.xpath("/html/body/div/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[3]/div/table/tbody/tr[2]/td[9]/div/div/div[2]/ul/li[1]"),
            By.xpath("/html/body/div/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[3]/div/table/tbody/tr[3]/td[9]/div/div/div[2]/ul/li[1]"),
            By.xpath("/html/body/div/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[3]/div/table/tbody/tr[4]/td[9]/div/div/div[2]/ul/li[1]"),
            By.xpath("/html/body/div/div[1]/div[2]/div[1]/div[2]/div/div[3]/div[3]/div/table/tbody/tr[5]/td[9]/div/div/div[2]/ul/li[1]")};

    String minPrice = "9500"; //I have placed 9500 instead of 2000, because a lot of currencies are displayed with min value of 2000
    String maxPrice = "99999";

    // ####################################################
    // METHODS FOR FIRST PART OF FE TEST
    // ####################################################

    public CoinMarketCap(WebDriver driver)
    {
        this.driver = driver;
    }

    public void OpenDropDownMenuWithCurrencies()
    {
        driver.findElement(dropDownMenuWithCurrencies).click();
    }

    public void SelectTop100Results()
    {
        driver.findElement(top100CurrenciesFromDropDownMenu).click();
    }

    public void CheckIfThereIs100CurrenciesDisplayed()
    {
        List<WebElement> currencies = driver.findElement(listOfTop100Currencies).findElements(By.className("cmc-table-row"));

        System.out.println("Number of currencies: " + currencies.size());

        if (currencies.size() != 100)
        {
            //test fail
            Assert.fail("There is no 100 currencies displayed");
        }
    }

    // ####################################################
    // METHODS FOR SECOND PART OF FE TEST
    // ####################################################

    public void OpenFiltersPanel()
    {
        driver.findElement(buttonShowFilters).click();
    }

    public void ExpandPriceFilter()
    {
        driver.findElement(buttonPriceFilter).click();
    }

    public void InsertMinInPriceFilter()
    {
        driver.findElement(inputFieldPriceRangeMin).sendKeys(minPrice);
    }

    public void InsertMaxInPriceFilter()
    {
        driver.findElement(inputFieldPriceRangeMax).sendKeys(maxPrice);
    }

    public void ClickOnApplyFilterButton()
    {
        driver.findElement(buttonApplyFilters).click();
    }

    public void AddCurrencyToWatchlist()
    {
        for (int i = 0; i <= buttonOpenOptionsMenuForSelectedCurrency.length - 1; i++)
        {
            System.out.println(i);
            driver.findElement(buttonOpenOptionsMenuForSelectedCurrency[i]).click();

            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            driver.findElement(buttonAddCurrencyToWatchlist[i]).click();
        }
    }

    public void ClickOnWatchlistButton()
    {
       driver.findElement(buttonWatchlist).click();
    }

    public void CheckForWatchlistedCurrencies()
    {
        //List<WebElement> currenciesOnWatchlist = driver.findElement(listOfCurrenciesOnWatchlist).findElements(By.className("cmc-table-row"));
        List<WebElement> currenciesOnWatchlist = driver.findElements(By.className("cmc-table-row"));

        System.out.println("Number of currencies: " + buttonAddCurrencyToWatchlist.length);

        if (buttonAddCurrencyToWatchlist.length != 5)
        {
            //test fail
            System.out.println("RADI!!!");
            Assert.assertFalse("There is no 5 currencies selected", true);
        }
    }
}
