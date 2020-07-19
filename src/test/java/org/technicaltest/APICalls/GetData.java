package org.technicaltest.APICalls;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData
{
    String urlRetrieveBoltFromCoinMarket = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/info?id=3843&CMC_PRO_API_KEY=";
    String apiKey = "b3a3cbd9-90bf-4a0c-8fb0-2ebe6833377e";

    public String boltSymbol;
    public String boltSourceCode;
    public String boltDateAdded;
    public String boltWebSite;

    public String response;



    public void GetBoltDataFromAPI() {
        response = RestAssured.get(urlRetrieveBoltFromCoinMarket + apiKey)
                .then().statusCode(200) // Here we are checking that error message is null
                .assertThat()
                .extract()
                .asString();
        boltSymbol = RestAssured.get(response).then().extract().path("symbol");
        boltSourceCode = RestAssured.get(response).then().extract().path("source code");
        boltDateAdded = RestAssured.get(response).then().extract().path("date_added");
        boltWebSite = RestAssured.get(response).then().extract().path("website");
    }
}
