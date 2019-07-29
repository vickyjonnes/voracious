package edu.kafka.test.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaProducer {
	@Value("${kafka.broker.topic.name}")
	private String topic;
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	public boolean sendMessage(String message) {
		return kafkaTemplate.send(topic, message)!=null;
	}
}
