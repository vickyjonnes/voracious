package edu.kafka.test.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaConsumer {

	@KafkaListener(topics="springTestApp", groupId="spring.test")
	public void consumeMessage(String message) {
		System.out.println(message);
	}
}
