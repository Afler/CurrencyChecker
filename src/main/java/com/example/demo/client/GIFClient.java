package com.example.demo.client;

import com.example.demo.model.GIFInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.example.demo.client.GIFClient.GIF_API_URL;

@FeignClient(value = "gif", url = GIF_API_URL)
public interface GIFClient {

    String GIF_API_URL = "api.giphy.com/v1/gifs/";
    String GIF_API_KEY = "Eokk6bx5q4rXgFBmie1MjCavKwzzeK1S";

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/random?api_key=" + GIF_API_KEY + "&tag={tag}",
            produces = "application/json"
    )
    GIFInfo findRandomGIFByTag(@PathVariable("tag") String tag);
}
