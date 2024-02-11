package com.rahul.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.rahul.springboot.entity.WikimediaData;
import com.rahul.springboot.repo.WikiRepo;

@Service
public class KafkaDatabaseConsumer {
	private static final Logger log=LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

	private WikiRepo repo;
	
	
	
	
	
	
	public KafkaDatabaseConsumer(WikiRepo repo) {
		this.repo = repo;
	}


	@KafkaListener(topics="wikimedia_recentchanges",groupId = "myGroupConsumer")
	public void consume(String message) {
			log.info(String.format("Message Recived -> %s", message));
			WikimediaData wikimediaData =new WikimediaData();
			wikimediaData.setWikiEventData(message);
			repo.save(wikimediaData);
	}

}
