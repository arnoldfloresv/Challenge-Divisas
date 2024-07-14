package com.divisas;

import com.google.gson.JsonObject;

import java.io.IOException;

public class CurrencyConverter {
    private JsonObject rates;

    public CurrencyConverter(String baseCurrency) throws IOException {
        rates = ApiClient.getExchangeRates(baseCurrency).getAsJsonObject("rates");
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        double fromRate = rates.get(fromCurrency).getAsDouble();
        double toRate = rates.get(toCurrency).getAsDouble();
        return (amount / fromRate) * toRate;
    }
}
