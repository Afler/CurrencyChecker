package com.example.demo.model;

import lombok.Data;

import java.util.HashMap;

@Data
public class CurrencyInfo {
    private String base;
    private HashMap<String, Double> rates;
}
