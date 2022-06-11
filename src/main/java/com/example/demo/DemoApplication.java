package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoApplication {

    @Value("${currency.api.url}")
    public static final String CURRENCY_API_URL = "";
    @Value("${currency.api.id}")
    public static final String CURRENCY_API_APP_ID = "";
    @Value("${currency.api.findAllURL}")
    public static final String CURRENCY_FIND_ALL_URL = "";

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
