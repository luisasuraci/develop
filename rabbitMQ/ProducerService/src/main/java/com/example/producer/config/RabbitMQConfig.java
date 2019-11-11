package com.example.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${celsius.rabbitmq.queue}")
	String celsiusQueue;

	@Value("${celsius.rabbitmq.exchange}")
	String celsiusExchange;

	@Value("${celsius.rabbitmq.routingkey}")
	private String celsiusRoutingKey;

	@Value("${ph.rabbitmq.queue}")
	String phQueue;

	@Value("${ph.rabbitmq.exchange}")
	String phExchange;

	@Value("${ph.rabbitmq.routingkey}")
	private String phRoutingKey;

	@Bean
	public TopicExchange getCelsiusExchange() {
		return new TopicExchange(celsiusExchange);
	}

	@Bean
	public Queue getCelsiusQueue() {
		return new Queue(celsiusQueue, true);
	}

	@Bean
	public Binding declareBindingCelsius() {
		return BindingBuilder.bind(getCelsiusQueue()).to(getCelsiusExchange()).with(celsiusRoutingKey);
	}

	@Bean
	public TopicExchange getPhExchange() {
		return new TopicExchange(phExchange);
	}

	@Bean
	public Queue getPhQueue() {
		return new Queue(phQueue, true);
	}

	@Bean
	public Binding declareBindingPh() {
		return BindingBuilder.bind(getPhQueue()).to(getPhExchange()).with(phRoutingKey);
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}
}
