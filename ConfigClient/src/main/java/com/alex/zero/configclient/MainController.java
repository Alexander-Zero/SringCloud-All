package com.alex.zero.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MainController {

    @Value("${server.port}")
    private Integer port;
    @Value("${msg}")
    private String msg;


    @GetMapping("/msg")
    public String msg() {
        return "this server port is " + port + " and message is " + msg;
    }

}
