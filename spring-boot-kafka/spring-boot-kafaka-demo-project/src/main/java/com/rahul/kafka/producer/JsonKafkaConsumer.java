package com.rahul.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rahul.kafka.model.User;

@Service
public class JsonKafkaConsumer {
	private static final Logger log=LoggerFactory.getLogger(JsonKafkaConsumer.class);
	@KafkaListener(topics = "KafkaJsonTopic",groupId = "myGroup")
	public void consume(User user) throws JsonProcessingException {
		ObjectMapper mapper =new ObjectMapper();
		String message=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
		
		log.info(String.format("Message Recived -> %s", message));
}

}
