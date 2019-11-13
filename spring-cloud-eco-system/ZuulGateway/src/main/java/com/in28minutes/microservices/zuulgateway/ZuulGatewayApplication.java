package com.in28minutes.microservices.zuulgateway;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
public class ZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}

	@Bean
    public Sampler defaultSampler(){
	    return Sampler.ALWAYS_SAMPLE;
    }
}
