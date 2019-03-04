package com.vickyjonnes.mongo.src.SpringBootWithMongoDb.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.vickyjonnes.mongo.src.SpringBootWithMongoDb.model.UserDocument;
import com.vickyjonnes.mongo.src.SpringBootWithMongoDb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	public String insertDocument(UserDocument user) {
		return repo.insert(user)!=null?"Sucess":"Fail";
	}
	
	public String insertMultipleDocuments(List<UserDocument> users) {
		return repo.insert(users)!=null ? "Success" : "Fail";
	}
	
	public String saveDocuments(List<UserDocument> users) {
		if(users.size()==1) {
			return repo.save(users.get(0)) != null ? "Success" : "Fail";
		}else {
			return repo.saveAll(users) != null ? "Success" : "Fail";
		}
		
	}
	
	public void deleteDocumentById(Integer id) {
		repo.deleteById(id);
	}
	
	public UserDocument fetchDocumentById(Integer id) {
		return repo.findById(id).get();
	}
	
	public List<UserDocument> fetchAllDocuments() {
		return repo.findAll();
	}
	
	
	
	
	

}
