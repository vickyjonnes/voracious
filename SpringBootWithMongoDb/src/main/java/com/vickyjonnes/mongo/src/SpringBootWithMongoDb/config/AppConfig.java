package com.vickyjonnes.mongo.src.SpringBootWithMongoDb.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
	@Value("${spring.data.mongodb.host}")
	public String mongo_server_host;
	@Value("${spring.data.mongodb.port}")
	public String mongo_server_port;
	@Value("${spring.data.mongodb.dbname}")
	public String mongo_db_name;
	
	public AppConfig(/*String host, String port,String db*/) {
//		this.mongo_server_host=host;
//		this.mongo_server_port=port;
//		this.mongo_db_name=db;
	}
	@PostConstruct
	public void init() {}
}
