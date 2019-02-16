package com.spring.boot.starter.src.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.spring.boot.starter.src.models.Topic;

@Service
public class TopicService {
	private List<Topic> allTopics=new ArrayList<Topic>(Arrays.asList(
			new Topic("Spring","Spring Boot","Spring Boot 2.14.2"),
			new Topic("Java","Core Java","Java Version 1.8"),
			new Topic("ORM","Hibernate","Hibernate version 4.6")));
	private IntStream a;
	
	public List<Topic> getAllTopics(){
		return allTopics;
	}
	
	public Optional<Topic> getTopic(String id){
		return allTopics.stream().filter(t->t.getTopicId().equalsIgnoreCase(id)).findFirst();
	}
	
	public boolean addTopic(Topic topic) {
		return allTopics.add(topic);
	}

	public boolean updateTopic(Topic topic, String id) {
		boolean flag=allTopics.stream().anyMatch((t)->t.getTopicId().equalsIgnoreCase(id));
		if(flag) {
			IntStream.iterate(0, i->i=i+1)
			.limit(allTopics.size())
			.filter((i)->allTopics.get(i).getTopicId().equalsIgnoreCase(id))
			.forEach((i)->allTopics.set(i, topic));
		}
		return flag;
	}

	public boolean deleteTopic(String id) {
		return allTopics.removeIf((t)->t.getTopicId().equalsIgnoreCase(id));
	}
}
