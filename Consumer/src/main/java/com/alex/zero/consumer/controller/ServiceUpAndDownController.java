package com.alex.zero.consumer.controller;

import com.alex.zero.consumer.service.ServiceHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//自动上下线
@RestController
@RequestMapping("/health")
public class ServiceUpAndDownController {
    @Autowired
    private ServiceHealthService healthService;


    @PostMapping("/status")
    public Boolean setHealthStatus(@RequestParam Boolean status) {
        healthService.setStatus(status);
        return false;
    }
}
