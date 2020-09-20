package com.alex.zero.providerapi.api;

import com.alex.zero.providerapi.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//若有hystrix , @RequestMapping 不能添加道类上
//@RequestMapping("/user")
public interface UserApi {

    @GetMapping("/user/name")
    String getName();

    @PostMapping("/user/xx")
    void addPerson(String name);

    @GetMapping("/user/test1")
    String test1(@RequestParam Integer id);

    @PostMapping("/user/test2")
    String test2(Person person);

    @GetMapping("/user/test3")
    String test3(@RequestParam Integer id, @RequestParam String name);

    @GetMapping("/user/port")
    String port();
}
