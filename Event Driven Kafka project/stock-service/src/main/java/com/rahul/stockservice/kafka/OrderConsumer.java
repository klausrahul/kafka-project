package com.rahul.stockservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.rahul.basedomain.dto.OrderEvent;

@Service
public class OrderConsumer {

	private static final Logger log = LoggerFactory.getLogger(OrderConsumer.class);

	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent event) {
		
		log.info("order Event Recived in Stock servie {}",event.toString());

	}
}