package com.example.producer.service;

import com.example.producer.model.Celsius;
import com.example.producer.model.Ph;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

	@Value("${celsius.rabbitmq.exchange}")
	private String celsiusExchange;
	
	@Value("${celsius.rabbitmq.routingkey}")
	private String celsiusRoutingkey;

	@Value("${ph.rabbitmq.exchange}")
	private String phExchange;

	@Value("${ph.rabbitmq.routingkey}")
	private String phRoutingkey;

	private final RabbitTemplate rabbitTemplate;

	public RabbitMQSender(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendCelsius(Celsius celsius) {
		rabbitTemplate.convertAndSend(celsiusExchange, celsiusRoutingkey, celsius);
		System.out.println("Send msg = " + celsius.toString());
	}

	public void sendPh(Ph ph) {
		rabbitTemplate.convertAndSend(phExchange, phRoutingkey, ph);
		System.out.println("Send msg = " + ph.toString());

	}
}