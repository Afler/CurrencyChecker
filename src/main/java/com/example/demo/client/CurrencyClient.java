package com.example.demo.client;

import com.example.demo.model.CurrencyInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.example.demo.client.CurrencyClient.CURRENCY_API_URL;


@FeignClient(value = "currency", url = CURRENCY_API_URL)
public interface CurrencyClient {

    String CURRENCY_API_URL = "https://openexchangerates.org/api/";
    String CURRENCY_API_APP_ID = "88191425adaa487397a19e3a398c54a6";

    @RequestMapping(
            method = RequestMethod.GET,
            value = "latest.json?app_id=" + CURRENCY_API_APP_ID,
            produces = "application/json"
    )
    CurrencyInfo findAll();

    @RequestMapping(
            method = RequestMethod.GET,
            value = "historical/{yesterdayDate}.json?app_id=" + CURRENCY_API_APP_ID,
            produces = "application/json")
    CurrencyInfo findYesterdayExchangeRate(@PathVariable("yesterdayDate") String yesterdayDate);
}
