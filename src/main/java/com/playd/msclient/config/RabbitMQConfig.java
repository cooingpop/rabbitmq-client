/*
 * @(#) RabbitMQConfig.java 2020. 04. 20.
 *
 * Copyright 2020. PlayD Corp. All rights Reserved.
 */
package com.playd.msclient.config;

import com.playd.msclient.model.Constants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 박준영
 */
@Configuration
@EnableRabbit
public class RabbitMQConfig {

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(Constants.EXCHANGE_NAME);
	}

	@Bean
	Queue incomingQueue() {
		return QueueBuilder.durable(Constants.INCOMING_QUEUE_NAME)
				.withArgument("x-dead-letter-exchange", "")
				.withArgument("x-dead-letter-routing-key", Constants.WAITING_QUEUE_NAME)
				.build();
	}

	@Bean
	Binding binding() {
		return BindingBuilder.bind(incomingQueue()).to(exchange()).with(Constants.ROUTING_KEY_NAME);
	}

	/**
	 * RabbitTemplate는 Spring boot에서 자동으로 빈 등록을 해주지만 받은 메시지 처리를 위한 messageConverter를 설정
	 * @param connectionFactory
	 * @param messageConverter
	 * @return
	 */
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(messageConverter);
		return template;
	}

	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

}
