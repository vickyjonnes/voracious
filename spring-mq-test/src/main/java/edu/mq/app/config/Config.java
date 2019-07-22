package edu.mq.app.config;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class Config {

	@Value("${active.mq.name}")
	private String mqName;
	@Value("${active.broker.url}")
	private String brokerURL;
	
	@Bean
	public Queue getQueue() {
		return new ActiveMQQueue(mqName);
	}
	
	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory();
		factory.setBrokerURL(brokerURL);
		return factory;
	}
	
	@Bean
	public JmsTemplate template() {
		return new JmsTemplate(connectionFactory());
	}
}
