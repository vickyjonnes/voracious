package com.vickyjonnes.mongo.src.SpringBootWithMongoDb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vickyjonnes.mongo.src.SpringBootWithMongoDb.model.UserDocument;
import com.vickyjonnes.mongo.src.SpringBootWithMongoDb.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET, value="/documents/all")
	public List<UserDocument> fetchAllDocuments(){
		return userService.fetchAllDocuments();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/documents/add")
	public String insertDocument(@RequestBody UserDocument user) {
		return userService.insertDocument(user);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/documents/addAll")
	public String insertMultipleDocuments(@RequestBody List<UserDocument> users) {
		return userService.insertMultipleDocuments(users);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/documents/save")
	public String saveDocuments(@RequestBody List<UserDocument> users) {
		return userService.saveDocuments(users);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/documents/delete/{id}")
	public void deleteDocumentById(@PathVariable Integer id) {
		userService.deleteDocumentById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/documents/find/{id}")
	public UserDocument fetchDocumentById(@PathVariable Integer id) {
		return userService.fetchDocumentById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/documents/file/save")
	public String saveFileToMongoDb() {
		return userService.storeFileToDb();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/documents/file/download")
	public String dowbloadFileFromMongo() {
		return userService.downloadFile();
	}
	
}
