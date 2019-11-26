package com.library.demo.LibraryDemo.repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
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
	private final static AtomicInteger USER_SEQ=new AtomicInteger();
	private final static AtomicInteger BOOK_SEQ=new AtomicInteger();
	static {
		//prepopulate few books
		bookStore.put(BOOK_SEQ.incrementAndGet(), new Book(BOOK_SEQ.get(), "Data Structure", BookStatus.AVAILABLE));
		bookStore.put(BOOK_SEQ.incrementAndGet(), new Book(BOOK_SEQ.get(), "Alchemist", BookStatus.AVAILABLE));
		bookStore.put(BOOK_SEQ.incrementAndGet(), new Book(BOOK_SEQ.get(), "Discovery", BookStatus.AVAILABLE));
		bookStore.put(BOOK_SEQ.incrementAndGet(), new Book(BOOK_SEQ.get(), "Love Story", BookStatus.AVAILABLE));
		bookStore.put(BOOK_SEQ.incrementAndGet(), new Book(BOOK_SEQ.get(), "Monk", BookStatus.AVAILABLE));
		
		//prepopulate few users as well
		
		userStore.put(USER_SEQ.incrementAndGet(), new User(USER_SEQ.get(),"Vipul"));
		userStore.put(USER_SEQ.incrementAndGet(), new User(USER_SEQ.get(),"Faizan"));
		userStore.put(USER_SEQ.incrementAndGet(), new User(USER_SEQ.get(),"Uday"));
		userStore.put(USER_SEQ.incrementAndGet(), new User(USER_SEQ.get(),"Atul"));
		userStore.put(USER_SEQ.incrementAndGet(), new User(USER_SEQ.get(),"Varun"));
	}
	
	@Override
	public boolean createAccount(User user) {
		user.setUserId(USER_SEQ.incrementAndGet());
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

	@Override
	public List<User> getAllUsers() {
		return userStore.values().stream().collect(Collectors.toList());
	}

	@Override
	public boolean isValidUser(int userId) {
		return userStore.containsKey(userId);
	}

	
	
}
