package com.alex.zero.provider.controller;

import com.alex.zero.providerapi.api.UserApi;
import com.alex.zero.providerapi.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProviderController implements UserApi {

    @Value("${server.port}")
    private Integer port;

    @Override
    public String getName() {
        return "this userName";
    }


    @Override
    public void addPerson(String name) {
        System.out.println("personName is " + name);
    }

    @Override
    public String test1(Integer id) {
        int i = 1 / 0;
        return id + "";
    }

    @Override
    public String test2(Person person) {
        String id = person.getId();
        String name = person.getName();
        return "id = " + id + ", name = " + name;
    }

    @Override
    public String test3(Integer id, String name) {
        return "id = " + id + ", name = " + name;
    }

    @Override
    public String port() {
        return "Provider Port is " + port;
    }
}
