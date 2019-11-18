package com.library.demo.LibraryDemo.repository;

import java.util.List;

import com.library.demo.LibraryDemo.model.Book;
import com.library.demo.LibraryDemo.model.BookStatus;
import com.library.demo.LibraryDemo.model.Transaction;
import com.library.demo.LibraryDemo.model.User;

public interface LibraryRepository {

	public boolean createAccount(User user);
	public String doOperation(Transaction txn);
	public Book checkAvailability(int bookId);
	public BookStatus getTransaction(Transaction txn);
	public List<Book> getAllBooks();
}
