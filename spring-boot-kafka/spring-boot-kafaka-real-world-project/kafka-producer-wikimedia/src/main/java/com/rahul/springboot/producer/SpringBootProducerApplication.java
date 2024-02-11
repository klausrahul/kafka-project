package com.rahul.springboot.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rahul.springboot.producer.config.WikimediaChangesProducer;

@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProducerApplication.class, args);
	}

	@Autowired
	private WikimediaChangesProducer changesProducer;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		changesProducer.sendMessage();
	}
}
