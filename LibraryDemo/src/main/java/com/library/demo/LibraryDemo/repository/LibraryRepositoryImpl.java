package com.library.demo.LibraryDemo.repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.library.demo.LibraryDemo.model.Book;
import com.library.demo.LibraryDemo.model.BookStatus;
import com.library.demo.LibraryDemo.model.Transaction;
import com.library.demo.LibraryDemo.model.User;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {

	private final static Map<Integer, Book> bookStore=new ConcurrentHashMap<>();
	private final static Map<Integer, User> userStore=new ConcurrentHashMap<>();
	private final static Map<Transaction, BookStatus> txnStore=new ConcurrentHashMap<>();
	
	static {
		//prepopulate few books
		bookStore.put(1, new Book(1, "Data Structure", BookStatus.AVAILABLE));
		bookStore.put(2, new Book(2, "Alchemist", BookStatus.AVAILABLE));
		bookStore.put(3, new Book(3, "Discovery", BookStatus.AVAILABLE));
		bookStore.put(4, new Book(4, "Love Story", BookStatus.AVAILABLE));
		bookStore.put(5, new Book(5, "Monk", BookStatus.AVAILABLE));
		
		//prepopulate few users as well
		
		userStore.put(1, new User(1, "Vipul"));
		userStore.put(2, new User(2, "Faizan"));
		userStore.put(3, new User(3, "Uday"));
		userStore.put(4, new User(4, "Atul"));
		userStore.put(5, new User(5, "Varun"));
	}
	
	@Override
	public boolean createAccount(User user) {
		return userStore.putIfAbsent(user.getUserId(), user)==null?true:false;
	}

	@Override
	public Book checkAvailability(int bookId) {
		if(Objects.nonNull(bookStore.get(bookId))) {
			return bookStore.get(bookId);
		}
		return null;
	}

	@Override
	public String doOperation(Transaction txn) {
		bookStore.get(txn.getBookId()).setStatus(txn.getStatus());
		txnStore.put(txn, txn.getStatus());
		switch(txn.getStatus()) {
		case AVAILABLE :
			return "Book returned successfully";
		case RESERVED:
			return "Book reserved successfully";
		case ISSUED:
			return "Book issued successfully";
		default: 
			return "Can't decide";
		}
	}
	
	@Override
	public BookStatus getTransaction(Transaction txn) {
		return txnStore.get(txn);
	}
	
	@Override
	public List<Book> getAllBooks(){
		return bookStore.values().stream().collect(Collectors.toList());
	}

}
