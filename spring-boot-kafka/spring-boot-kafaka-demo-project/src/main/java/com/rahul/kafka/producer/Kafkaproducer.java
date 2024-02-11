package com.rahul.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Kafkaproducer {

	private static final Logger log=LoggerFactory.getLogger(Kafkaproducer.class);
	private KafkaTemplate<String, String> kafkaTemplate;

	public Kafkaproducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(String message) {
		log.info(String.format("Message sent %s", message));
		kafkaTemplate.send("KafkaDemo", message);
	}
	
	
}