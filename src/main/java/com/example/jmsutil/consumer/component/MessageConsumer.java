package com.example.jmsutil.consumer.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class MessageConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);
	
	@JmsListener(destination = "genesis.queue")
	public void messageListener (String message) {
		LOGGER.info("Message received: {}",message);
	}
}
