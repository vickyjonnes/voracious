package com.spring.boot.data.src.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.data.src.models.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
