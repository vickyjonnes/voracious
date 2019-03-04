package com.vickyjonnes.mongo.src.SpringBootWithMongoDb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vickyjonnes.mongo.src.SpringBootWithMongoDb.model.UserDocument;

public interface UserRepository extends MongoRepository<UserDocument, Integer> {

}
