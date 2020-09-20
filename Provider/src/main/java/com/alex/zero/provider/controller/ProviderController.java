package com.alex.zero.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @GetMapping("/test")
    public String getString() {
        return "welcome to the Provider World!";
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/port")
    public String getPort() {
        return "my port is " + port;
    }
}
