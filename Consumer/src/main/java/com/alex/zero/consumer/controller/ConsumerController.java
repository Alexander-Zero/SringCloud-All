package com.alex.zero.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private EurekaDiscoveryClient eurekaDiscoveryClient;
    @Autowired
    private LoadBalancerClient balancerClient;
    @GetMapping("/test")
    public String getClient() {
        List<String> services = discoveryClient.getServices();
        for (String str : services) {
            System.out.println(str);
            List<ServiceInstance> instances = discoveryClient.getInstances(str);
            System.out.println(instances);
        }
        List<String> services1 = eurekaDiscoveryClient.getServices();
        List<ServiceInstance> provider = eurekaDiscoveryClient.getInstances("provider");
        ServiceInstance serviceInstance = provider.get(1);
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/test";

        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        String body = forEntity.getBody();


        ServiceInstance provider1 = balancerClient.choose("provider");
        String url2 = "http://" + provider1.getHost() + ":" + provider1.getPort() + "/port";
        String portInfo = restTemplate.getForEntity(url2, String.class).getBody();
        System.out.println(portInfo);

        return "This is Client"+ portInfo;
    }

}
