package com.enduser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

	@KafkaListener(topics = AppConstent.LOCATION_TOPIC_NAME,groupId = AppConstent.GROUP_ID)
	public void updatedLocation(String value) {
		System.out.println(value);
		
	}
}
