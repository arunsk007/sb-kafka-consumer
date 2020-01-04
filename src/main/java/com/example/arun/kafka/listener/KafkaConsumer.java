package com.example.arun.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.arun.kafka.model.User;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics = "test", groupId="grp_string" )
	public void consume(String message) {
		System.out.println("Consumed in topic: test, message: "+message);
	}
	
	@KafkaListener(topics = "test-json",groupId = "grp_json",containerFactory = "userKafkaListenerFactory")
	public void consumeUserJson(User user) {
		System.out.println("Consumed in topic: test-json , message:"+user);
	}

}
