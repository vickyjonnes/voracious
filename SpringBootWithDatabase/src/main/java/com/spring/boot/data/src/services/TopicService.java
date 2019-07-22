package com.spring.boot.data.src.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.data.src.models.Topic;
import com.spring.boot.data.src.repository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		List<Topic> topics=new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getTopic(String id){
		return topicRepository.findById(id);
	}
	
	public boolean addTopic(Topic topic) {
		return topicRepository.save(topic) != null ? true : false;
	}

	public boolean updateTopic(Topic topic) {
		return topicRepository.save(topic) != null ? true : false;
	}

	public boolean deleteTopic(String id) {
		topicRepository.deleteById(id);
		return true;
	}
}
