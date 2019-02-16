package com.spring.boot.starter.src.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
	private String topicId;
	private String topicName;
	private String description;
}
