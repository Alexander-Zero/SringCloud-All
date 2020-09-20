package com.alex.zero.feighconsumer.test;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class RestService {


    @HystrixCommand(defaultFallback = "test6Back")
    public String test6() {
        int i = 1 / 0;
        return "正常的服务";
    }

    public String test6Back() {
        return "服务降级了";
    }
}
