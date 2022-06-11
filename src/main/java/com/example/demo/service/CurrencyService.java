package com.example.demo.service;

import com.example.demo.client.CurrencyClient;
import com.example.demo.model.CurrencyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CurrencyService {

    private final CurrencyClient currencyClient;

    @Autowired
    public CurrencyService(CurrencyClient currencyClient) {
        this.currencyClient = currencyClient;
    }

    public CurrencyInfo findAll() {
        return currencyClient.findAll();
    }

    public Double findExchangeRateByCode(String currCode) {
        return this.findAll().getRates().get(currCode);
    }

    public Double findYesterdayExchangeRateByCode(String currCode) {
        CurrencyInfo yesterdayExchangeRate = currencyClient.findYesterdayExchangeRate(LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return yesterdayExchangeRate.getRates().get(currCode);
    }

    public Boolean hasIncreasedPerDay(String currencyCode) {
        try {
            return findExchangeRateByCode(currencyCode) > findYesterdayExchangeRateByCode(currencyCode);
        } catch (NullPointerException e) {
            return null;
        }
    }
}
