package com.example.producer.controller;

import com.example.producer.model.Celsius;
import com.example.producer.model.Ph;
import com.example.producer.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

