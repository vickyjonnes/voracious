package com.vickyjonnes.mongo.src.SpringBootWithMongoDb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:/properties/application_${spring.profiles.active}.properties")
@SpringBootApplication
public class SpringBootWithMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithMongoDbApplication.class, args);
	}

}
