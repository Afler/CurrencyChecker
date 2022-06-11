package com.example.demo.model;

import lombok.Data;

@Data
public class GIFInfo {
    private GIFData data;

    @Data
    private class GIFData {
        private String type;
        private String id;
        private String embed_url;
    }
}
