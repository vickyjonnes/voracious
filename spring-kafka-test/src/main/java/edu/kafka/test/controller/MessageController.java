package edu.kafka.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.kafka.test.producer.MyKafkaProducer;

@RestController
@RequestMapping("/kafka")
public class MessageController {

	@Autowired
	private MyKafkaProducer producer;
	@RequestMapping(value="/publish/{message}", method=RequestMethod.GET)
	public String getAndSendMessageToKafkaBroker(@PathVariable String message) {
		boolean result=producer.sendMessage(message);
		return result ? "Success" :"Fail";
	}
}
