package com.rahul.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	private static final Logger log=LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics="KafkaDemo",groupId = "myGroup")
	public void consume(String message) {
			log.info(String.format("Message Recived -> %s", message));
	}
}
