package com.alex.zero.feighconsumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class ParameterConfig {

    @Value("${server.port}")
    private Integer port;

    @Value("${msg}")
    private String msg;

    public Integer getPort() {
        return port;
    }

    public String getMsg() {
        return msg;
    }
}
