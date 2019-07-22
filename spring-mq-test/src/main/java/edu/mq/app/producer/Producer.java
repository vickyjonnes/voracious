package edu.mq.app.producer;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queue;
	
	@RequestMapping("/rest/publish/{message}")
	public String publishString(@PathVariable String message) {
		jmsTemplate.convertAndSend(queue, message);
		return "Published Successfully";
	}
}
