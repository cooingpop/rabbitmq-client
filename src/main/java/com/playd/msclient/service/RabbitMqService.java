/*
 * @(#) RabbitMqService.java 2020. 04. 22.
 *
 * Copyright 2020. PlayD Corp. All rights Reserved.
 */
package com.playd.msclient.service;

import com.playd.msclient.model.CustomMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.playd.msclient.model.Constants.*;

/**
 * @author 박준영
 */

@Component
public class RabbitMqService {

	private static final Logger logger = LoggerFactory.getLogger(RabbitMqService.class);

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMessage(CustomMessage customMessage) {
		rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_NAME, customMessage);
	}

	@Scheduled(fixedDelay = 500L)
	public void sendMessage2() {
		Map<String, Object> message = new HashMap<>();
		int a = new Random().nextInt(10);
		message.put("msg", "Hello :: " + a );
		logger.info("Sending message...");
		try {
			rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_NAME, message);
		} catch (Exception e ) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

}
