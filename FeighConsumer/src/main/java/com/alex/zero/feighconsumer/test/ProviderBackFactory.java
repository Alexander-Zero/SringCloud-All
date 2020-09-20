package com.alex.zero.feighconsumer.test;


import com.alex.zero.providerapi.model.Person;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ProviderBackFactory implements FallbackFactory<ConsumerUser> {
    @Override
    public ConsumerUser create(Throwable throwable) {
        return new ConsumerUser() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public void addPerson(String name) {

            }

            @Override
            public String test1(Integer id) {
                return "服务降级了," + throwable.getClass().getName();
            }

            @Override
            public String test2(Person person) {
                return null;
            }

            @Override
            public String port() {
                return null;
            }

            @Override
            public String test3(Integer id, String name) {
                return null;
            }
        };
    }
}
