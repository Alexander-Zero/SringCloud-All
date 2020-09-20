package com.alex.zero.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String getPortTest() {
        String url = "http://provider/port";
        String body = restTemplate.getForEntity(url, String.class).getBody();
        return body;
    }


}
