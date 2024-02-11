package com.rahul.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic getTopic() {
		return TopicBuilder.name("KafkaDemo").partitions(10).build();
	}
	
	@Bean
	public NewTopic getJsonTopic() {
		return TopicBuilder.name("KafkaJsonTopic").partitions(10).build();
	}
}
