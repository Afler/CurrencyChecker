package com.example.demo.service;

import com.example.demo.client.GIFClient;
import com.example.demo.model.GIFInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GIFService {

    private final GIFClient gifClient;

    @Autowired
    public GIFService(GIFClient gifClient) {
        this.gifClient = gifClient;
    }

    public GIFInfo findRandomGIFByTag(String tag) {
        return gifClient.findRandomGIFByTag(tag);
    }
}
