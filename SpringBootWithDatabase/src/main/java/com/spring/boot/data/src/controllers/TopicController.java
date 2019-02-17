package com.spring.boot.data.src.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.data.src.models.Topic;
import com.spring.boot.data.src.services.TopicService;
/*
	This is a demo controller which will control the requests in this project
*/
@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> fetchTopics(){
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic geTopic(@PathVariable String id) throws RuntimeException {
		return topicService.getTopic(id).orElseThrow(()->new RuntimeException("No Topic with id:"+id));
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public String addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic)? "Succefully Added to Topics" : "Failed to add";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public String updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		return topicService.updateTopic(topic)? "Succefully updated Topic" : "Failed to update";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/delete/{id}")
	public String deleteTopic(@PathVariable String id) {
		return topicService.deleteTopic(id)? "Succefully deleted Topic" : "Failed to update";
	}
}
