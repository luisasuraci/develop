package com.example.manager.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

	@Value("${celsius.queue.name}")
	String celsiusQueueName;

	@Value("${ph.queue.name}")
	String phQueueName;

	@Value("${rabbitmq.username}")
	String username;

	@Value("${rabbitmq.password}")
	private String password;

	@Bean
    Queue celsiusQueue() {
		return new Queue(celsiusQueueName, true);
	}

	@Bean
	Queue phQueue() {
		return new Queue(phQueueName, true);
	}

	@Bean
	public Jackson2JsonMessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
}
