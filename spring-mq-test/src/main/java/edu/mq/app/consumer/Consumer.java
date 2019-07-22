package edu.mq.app.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	@JmsListener(destination="spring.active.mq.test")
	public void consume(String message) {
		System.out.println("Message recieved "+message);
	}
}
