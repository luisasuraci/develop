package com.in28minutes.microservices.limitsservice.controller;

import com.in28minutes.microservices.limitsservice.config.Configuration;
import com.in28minutes.microservices.limitsservice.config.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    @HystrixCommand(defaultFallback = "retrieveConfiguration")
    public LimitConfiguration retrieveLimitsFromConfiguration(){
        return new LimitConfiguration(configuration.getMax(),configuration.getMin());
    }

    public LimitConfiguration retrieveConfiguration(){
        throw new RuntimeException("Not available");
    }
}
