package com.example.demo.controller;

import com.example.demo.model.GIFInfo;
import com.example.demo.service.CurrencyService;
import com.example.demo.service.GIFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final CurrencyService currencyService;
    private final GIFService gifService;

    @Autowired
    public RestController(CurrencyService currencyService, GIFService gifService) {
        this.currencyService = currencyService;
        this.gifService = gifService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Worked");
    }

    @GetMapping("/check/{currencyCode}")
    public ResponseEntity<Object> check(@PathVariable String currencyCode) {
        Boolean checkResult = currencyService.hasIncreasedPerDay(currencyCode);
        if (checkResult == null) {
            return ResponseEntity.badRequest().body("Wrong currency code.");
        }
        if (checkResult) {
            return ResponseEntity.ok(gifService.findRandomGIFByTag("rich"));
        } else {
            return ResponseEntity.ok(gifService.findRandomGIFByTag("poor"));
        }
    }
}
