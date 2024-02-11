package com.rahul.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rahul.kafka.model.User;
import com.rahul.kafka.producer.Kafkaproducer;
import com.rahul.kafka.producer.jsonKafkaProducer;

@RestController
@RequestMapping("/api/v1/kakfka")
public class MessageController {

	private Kafkaproducer kafkaproducer;
	private jsonKafkaProducer jsonKafkaProducer;

	@Autowired
	public MessageController(Kafkaproducer kafkaproducer,jsonKafkaProducer jsonKafkaProducer) {
		this.kafkaproducer = kafkaproducer;
		this.jsonKafkaProducer = jsonKafkaProducer;
	}
	
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message")  String message){
		
		kafkaproducer.sendMessage(message);
		return ResponseEntity.ok("message sent to the topic");
	}
	
	
	@PostMapping("/publishJson")
	public ResponseEntity<String> publishJsonmessage(@RequestBody User user) throws JsonProcessingException{
		
		jsonKafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json message sent to the topic");
	}
	
	
	
}
