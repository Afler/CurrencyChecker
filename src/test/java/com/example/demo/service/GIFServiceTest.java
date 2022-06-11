package com.example.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GIFServiceTest {

    @Autowired
    private GIFService gifService;

    @Test
    void findRandomGIFByTag() {
        Assertions.assertNotNull(gifService.findRandomGIFByTag("rich"));
        Assertions.assertNotNull(gifService.findRandomGIFByTag("poor"));
    }
}