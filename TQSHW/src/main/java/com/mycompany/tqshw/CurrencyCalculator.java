package com.mycompany.tqshw;
import java.util.Map;

public class CurrencyCalculator {
    private final ExchangeRateService service;
    private final Map<String,Double> rates;
    
    public CurrencyCalculator(){
        service = new ExchangeRateService();
        rates = service.getRatesCache();
    }
    
    public double convert(String from, double amount, String to) {
        if(!(rates.containsKey(from) && rates.containsKey(to)))
            throw new RuntimeException("Currency not accepted.");
        return (amount/rates.get(from))*rates.get(to);
    }
}
