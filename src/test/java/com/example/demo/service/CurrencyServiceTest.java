package com.example.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CurrencyServiceTest {

    @Autowired
    private CurrencyService currencyService;

    @Test
    void findAll() {
        Assertions.assertNotNull(currencyService.findAll());
    }

    @Test
    void findExchangeRateByCode() {
        Assertions.assertNotNull(currencyService.findExchangeRateByCode("RUB"));
    }

    @Test
    void findYesterdayExchangeRateByCode() {
        Assertions.assertNotNull(currencyService.findYesterdayExchangeRateByCode("RUB"));
    }
}