package com.alex.zero.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @GetMapping("/test")
    public String getString(){
        return "welcome to the Provider World!";
    }

}
