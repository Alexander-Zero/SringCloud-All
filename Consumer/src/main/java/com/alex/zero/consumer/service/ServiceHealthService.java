package com.alex.zero.consumer.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

//手动上下线服务
@Service
public class ServiceHealthService implements HealthIndicator {

    private Boolean status;

    @Override
    public Health health() {
        if (status) {
            return new Health.Builder().up().build();
        } else {
            return new Health.Builder().down().build();
        }
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
