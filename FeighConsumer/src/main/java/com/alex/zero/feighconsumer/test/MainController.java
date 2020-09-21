package com.alex.zero.feighconsumer.test;

import com.alex.zero.providerapi.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
@RefreshScope
public class MainController {
    @Autowired
    private ConsumerUser consumerUser;

    @Autowired
    private MyConsumerUser myConsumerUser;

    @Autowired
    private RestService restService;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/test1")
    public String test1() {
        return consumerUser.getName();
    }

    @GetMapping("/test2")
    public String test2() {
        return myConsumerUser.getPort();
    }

    @GetMapping("/test3")
    public String test3(Integer id) {
        return consumerUser.test1(id);
    }

    @GetMapping("/test4")
    public String test4(Person person) {
        return consumerUser.test2(person);
    }

    @GetMapping("/test5")
    public String test5(Integer id, String name) {
        return consumerUser.test3(id, name);
    }

    @GetMapping("/test6")
    public String test6() {
        return restService.test6();
    }

    @GetMapping("/port")
    public String port() {
        return "Consumer Port is " + port + ", " + consumerUser.port();
    }

    @Value("${msg}")
    private String msg;

    @GetMapping("/msg")
    private String getMsg() {
        return "port is " + port + ",Message is " + msg;
    }


}
