package com.alex.zero.feighconsumer.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "provider")
@FeignClient(name = "xxoo", url = "http://eureka1.com:6379")
public interface MyConsumerUser {

    @GetMapping("/port")
    public String getPort();
}
