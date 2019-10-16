package com.logicbig.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    @Value("${eureka.instance.metadataMap.instance-id}")
    private String instanceId;

    @GetMapping("/home")
    public HelloObject getHelloWordObject() {
        HelloObject hello = new HelloObject();
        hello.setMessage("Hi there! instance id: " + instanceId);
        return hello;
    }
}