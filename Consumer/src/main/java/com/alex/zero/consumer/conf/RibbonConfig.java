package com.alex.zero.consumer.conf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


//设置负载均衡算法
@Configuration
public class RibbonConfig {
    @Bean
    public IRule getIRule() {
        return new RandomRule();
    }

    @Bean
    //若该方法上加上@LoadBalaced,请求地址不再是ip+port,而是instanceName,例如provider
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//ms
        factory.setConnectTimeout(15000);//ms
        return factory;
    }
}
