package com.divisas;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class ApiClient {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/52a41a93f2b441de2207a470/latest/USD";

    public static JsonObject getExchangeRates(String baseCurrency) throws IOException {
        String response = Request.Get(API_URL + baseCurrency).execute().returnContent().asString();
        return JsonParser.parseString(response).getAsJsonObject();
    }
}