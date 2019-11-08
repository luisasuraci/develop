package com.example.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableRabbit
public class ManagerApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
	}
}
