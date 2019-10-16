package com.javainuse.controller;

import com.javainuse.model.Celsius;
import com.javainuse.model.Ph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.javainuse.model.Employee;
import com.javainuse.service.RabbitMQSender;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/javainuse-rabbitmq/")
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/celsius", produces = MediaType.APPLICATION_JSON_VALUE)
	public String producerCelsius(@RequestBody Celsius celsius, BindingResult result) throws Exception {
		rabbitMQSender.sendCelsius(celsius);
		return "Message sent to the RabbitMQ JavaInUse Successfully";
	}

	@GetMapping(value = "/ph", produces = MediaType.APPLICATION_JSON_VALUE)
	public String producerPh(@RequestBody Ph ph, BindingResult result) throws Exception {
		rabbitMQSender.sendPh(ph);
		return "Message sent to the RabbitMQ JavaInUse Successfully";
	}

}

