package org.technicaltest.tests;

/*
@author Branislav Guduric

In this class are BackEnd automatic tests for website https://coinmarketcap.com/
Testing include:
    - Checking if there is error message
    - Checking for correct symbol for Bolt currency
    - Checking for source code for Bolt currency
    - Checking for date added for Bolt currency
    - Checking for website for Bolt currency
    - Checking for valid URL for logo  for Bolt currency


*/

import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CoinMarketCapBackEndTest
{
    String urlRetrieveBoltFromCoinMarket = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/info?id=3843&CMC_PRO_API_KEY=";
    String apiKey = "b3a3cbd9-90bf-4a0c-8fb0-2ebe6833377e";

    /*
    public String boltSymbol;
    public String boltSourceCode;
    public String boltDateAdded;
    public String boltWebSite;
    public String boltLogoURL;
    public String response = GetBoltDataFromAPI();

    public String GetBoltDataFromAPI() {
        response = RestAssured.get(urlRetrieveBoltFromCoinMarket + apiKey)
                .then().statusCode(200) // Here we are checking that error message is null
                .assertThat()
                .extract()
                .asString();
        boltSymbol = RestAssured.get(response).then().extract().path("data.3843.symbol");
        boltSourceCode = RestAssured.get(response).then().extract().path("data.3843.urls.source_code[0]");
        boltDateAdded = RestAssured.get(response).then().extract().path("data.3843.date_added");
        boltWebSite = RestAssured.get(response).then().extract().path("data.3843.urls.website[0]");
        boltLogoURL= RestAssured.get(response).then().extract().path("data.3843.logo");;

        return response;
    }

     */

    String expectedSymbol = "BOLT";
    String expectedSourceCode = "https://github.com/SyQic-Ops/bolt";
    String expectedDateAdded = "2019-04-05T00:00:00.000Z";
    String expectedWebSite = "https://bolt.global/";
    String expectedLogoURL = "https://s2.coinmarketcap.com/static/img/coins/64x64/3843.png";

    //public GetData data  = new GetData();

    @Test
    public void CheckForErrorMessage()
    {
        when().get(urlRetrieveBoltFromCoinMarket + apiKey)
        .then().statusCode(200);
    }

    @Test
    public void CheckForSymbol()
    {
        //Assert.assertEquals(expectedSymbol, boltSymbol);
        when().get(urlRetrieveBoltFromCoinMarket + apiKey)
        .then().body("data.3843.symbol", equalTo(expectedSymbol) );
    }

    @Test
    public void CheckForSourceCode()
    {
        //Assert.assertEquals(expectedSourceCode, boltSourceCode);
        when().get(urlRetrieveBoltFromCoinMarket + apiKey)
        .then().body("data.3843.urls.source_code[0]", equalTo(expectedSourceCode) );
    }

    @Test
    public void CheckForDateAdded()
    {
        //Assert.assertEquals(expectedDateAdded, boltDateAdded);
        when().get(urlRetrieveBoltFromCoinMarket + apiKey)
        .then().body("data.3843.date_added", equalTo(expectedDateAdded) );
    }

    @Test
    public void CheckForWebSite()
    {
        //Assert.assertEquals(expectedWebSite,boltWebSite);
        when().get(urlRetrieveBoltFromCoinMarket + apiKey)
        .then().body("data.3843.urls.website[0]", equalTo(expectedWebSite) );
    }

    @Test
    public void CheckForValidURLForLogoIcon()
    {
        when().get(urlRetrieveBoltFromCoinMarket + apiKey)
        .then().body("data.3843.logo", equalTo(expectedLogoURL) );
    }
}