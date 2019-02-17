package com.spring.boot.data.src.models;


import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
	@Id
	private String topicId;
	private String topicName;
	private String description;
}
