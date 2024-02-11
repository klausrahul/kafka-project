package com.rahul.emailservice.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.rahul.basedomain.dto.OrderEvent;

@Service
public class EmailOrderConsumer {
	
	private static final Logger log = LoggerFactory.getLogger(EmailOrderConsumer.class);

	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent event) {
		
		log.info("order Event Recived in Email servie {}",event.toString());

	}
}
