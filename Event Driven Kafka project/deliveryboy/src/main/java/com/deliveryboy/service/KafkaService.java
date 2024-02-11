package com.deliveryboy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deliveryboy.config.AppConstents;

@Service
public class KafkaService {

	private static final Logger log=LoggerFactory.getLogger(KafkaService.class); 
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	public boolean updateLocation(String location) {
		kafkaTemplate.send(AppConstents.LOCATION_TOPIC_NAME, location);
		log.info("Message produced");
		return true;
	}
}
