package com.rahul.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rahul.kafka.model.User;

@Service
public class jsonKafkaProducer {
	
	private static final Logger log=LoggerFactory.getLogger(jsonKafkaProducer.class);
	
	private KafkaTemplate<String, User> kafkaTemplate;
	@Autowired
	public jsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User user) throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		String result=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
		
		Message<User> message=MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC,"KafkaJsonTopic").build();
		log.info(String.format("Message sent %s",result));
		kafkaTemplate.send(message);
	}
	
	

}
