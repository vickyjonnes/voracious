package com.vickyjonnes.mongo.src.SpringBootWithMongoDb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;

@Configuration
public class MongoConfig {
	
	@Bean
	public GridFSBucket getGridBucket(MongoDatabase db) {
		return GridFSBuckets.create(db);
	}
	
	@Bean
	public MongoDatabase mongoDatabase(AppConfig config,MongoClient client) {
		return client.getDatabase(config.mongo_db_name);
	}
	
	@Bean
	public MongoClient client(ServerAddress address) {
		return new MongoClient(address);
	}
	
	@Bean
	public ServerAddress address(AppConfig config) {
		return new ServerAddress(config.mongo_server_host, Integer.valueOf(config.mongo_server_port));
	}
}
