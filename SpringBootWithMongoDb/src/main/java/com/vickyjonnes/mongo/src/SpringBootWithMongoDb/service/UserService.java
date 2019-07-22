package com.vickyjonnes.mongo.src.SpringBootWithMongoDb.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.model.GridFSDownloadOptions;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;
import com.vickyjonnes.mongo.src.SpringBootWithMongoDb.model.UserDocument;
import com.vickyjonnes.mongo.src.SpringBootWithMongoDb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	@Autowired
	private GridFSBucket bucket;
	
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

	public String storeFileToDb() {
		String fileId="No Id";
		try(InputStream stream=new FileInputStream(new File("C:\\Users\\mohammad.faizan\\Desktop\\lakshdweep.txt"))) {
			GridFSUploadOptions options = new GridFSUploadOptions()
                    .chunkSizeBytes(17000)
                    .metadata(new Document("type", "data"));
			 ObjectId objId = bucket.uploadFromStream("lakshadweep-trip-data", stream, options);
			 fileId=objId.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileId;
	}

	public String downloadFile() {
		boolean isException=false;
		try(FileOutputStream stream=new FileOutputStream(new File("C:\\Users\\mohammad.faizan\\Desktop\\download\\lakshdweep.txt"))){
			GridFSDownloadOptions options=new GridFSDownloadOptions().revision(0);
			bucket.downloadToStream("lakshadweep-trip-data", stream, options);
		}catch(IOException e) {
			isException=true;
		}
		return isException? "Failes":"Success";
	}
	
	
	
	
	

}
