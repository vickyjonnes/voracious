package com.library.demo.LibraryDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.demo.LibraryDemo.model.Book;
import com.library.demo.LibraryDemo.model.BookStatus;
import com.library.demo.LibraryDemo.model.Transaction;
import com.library.demo.LibraryDemo.model.User;
import com.library.demo.LibraryDemo.service.LibraryService;

@RestController
@RequestMapping(path="/book", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
public class LibraryController {

	@Autowired
	LibraryService library;
	
	@PutMapping(path="/createAccount")
	public String createAccount(@RequestBody User user) {
		boolean status=library.createAccount(user);
		if(status)
			return "acount created success";
		else
			return "account already present";
	}
	
	@PostMapping(path="/reserveBook")
	public String reserveBook(@RequestBody Transaction txn) {
		txn.setStatus(BookStatus.RESERVED);
		return library.reserveBook(txn);
	}
	
	@PostMapping(path="/unreserveBook")
	public String unreserveBook(@RequestBody Transaction txn) {
		txn.setStatus(BookStatus.AVAILABLE);
		return library.unReserveBook(txn);
	}
	
	@PostMapping(path="/issueBook")
	public String issueBook(@RequestBody Transaction txn) {
		txn.setStatus(BookStatus.ISSUED);
		return library.issueBook(txn);
	}
	
	@PostMapping(path="/returnBook")
	public String returnBook(@RequestBody Transaction txn) {
		txn.setStatus(BookStatus.AVAILABLE);
		return library.returnBook(txn);
	}
	
	@PostMapping(path="/isAvailable/{bookId}")
	public String checkAvailability(@PathVariable int bookId) {
		return library.checkAvailability(bookId).name();
	}
	
	@GetMapping(path="/allBooks")
	public List<Book> getAllBooks(){
		return library.getAllBooks();
	}
}
