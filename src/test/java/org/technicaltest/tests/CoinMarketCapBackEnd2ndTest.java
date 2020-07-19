package org.technicaltest.tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.technicaltest.pages.CoinMarketCap;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class CoinMarketCapBackEnd2ndTest {
    String urlRetrieveCurrencyWithSymbol = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/map?symbol=";
    String urlRetrieveCurrencyApiKeyString = "&CMC_PRO_API_KEY=";
    String apiKey = "b3a3cbd9-90bf-4a0c-8fb0-2ebe6833377e";

    String urlRetrieveCurrencyWithIDForCoversion = "https://pro-api.coinmarketcap.com/v1/tools/price-conversion?id=";
    String urlRetrieveCurrencyApiKeyAndAmountString = "&amount=1&CMC_PRO_API_KEY=";

    String symbolDeutscheeMark = "DEM";
    String symbolBitcoin = "BTC";
    String symbolZero = "ZER";

    int expectedIdDEM = 72;
    int expectedIdBTC = 1;
    int expectedIdZER = 1578;

    @Test
    public void CheckIDForDEM()
    {
        when().get(urlRetrieveCurrencyWithSymbol + symbolDeutscheeMark + urlRetrieveCurrencyApiKeyString+ apiKey)
        .then().body("data[0].id", equalTo(expectedIdDEM) );
    }

    @Test
    public void ConvertDEMtoUSD()
    {
        when().get(urlRetrieveCurrencyWithIDForCoversion + expectedIdDEM + urlRetrieveCurrencyApiKeyAndAmountString + apiKey)
        .then().body("data.quote.USD.price", not(0));

        /*
        when().get(urlRetrieveCurrencyWithIDForCoversion + expectedIdDEM + urlRetrieveCurrencyApiKeyAndAmountString + apiKey)
        .then().body("data.quote.USD.price", greaterThan(0));
        */


        /*
        when().get(urlRetrieveCurrencyWithIDForCoversion + expectedIdDEM + urlRetrieveCurrencyApiKeyAndAmountString + apiKey)
        .then().log().all();
        */
    }

    @Test
    public void CheckIDForBTC()
    {
        when().get(urlRetrieveCurrencyWithSymbol + symbolBitcoin + urlRetrieveCurrencyApiKeyString+ apiKey)
        .then().body("data[0].id", equalTo(expectedIdBTC) );
    }

    @Test
    public void ConvertBTCtoUSD()
    {
        when().get(urlRetrieveCurrencyWithIDForCoversion + expectedIdBTC + urlRetrieveCurrencyApiKeyAndAmountString + apiKey)
                .then().body("data.quote.USD.price", not(0));
    }

    @Test
    public void CheckIDForZER()
    {
        when().get(urlRetrieveCurrencyWithSymbol + symbolZero + urlRetrieveCurrencyApiKeyString+ apiKey)
        .then().body("data[0].id", equalTo(expectedIdZER) );
    }

    @Test
    public void ConvertZERtoUSD()
    {
        when().get(urlRetrieveCurrencyWithIDForCoversion + expectedIdZER + urlRetrieveCurrencyApiKeyAndAmountString + apiKey)
                .then().body("data.quote.USD.price", not(0));
    }
}
