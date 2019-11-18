package com.library.demo.LibraryDemo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.demo.LibraryDemo.model.Book;
import com.library.demo.LibraryDemo.model.BookStatus;
import com.library.demo.LibraryDemo.model.Transaction;
import com.library.demo.LibraryDemo.model.User;
import com.library.demo.LibraryDemo.repository.LibraryRepository;

@Service
public class LibraryService {
	
	@Autowired
	LibraryRepository bookDb;
	
	public boolean createAccount(User user) {
		return bookDb.createAccount(user);
	}

	public BookStatus checkAvailability(int bookId) {
		Book book=bookDb.checkAvailability(bookId);
		return Objects.nonNull(book)?book.getStatus():BookStatus.UNAVAILABLE;
	}

	public String reserveBook(Transaction txn) {
		Book book=bookDb.checkAvailability(txn.getBookId());
		if(Objects.isNull(book)){
			return "Book is not available";
		}

		BookStatus status=book.getStatus();

		if(BookStatus.AVAILABLE==status) {
			return bookDb.doOperation(txn);
		}else if(BookStatus.RESERVED==status) {
			return "Book is already reserved by someone";
		}else {
			return "Book is already issued";
		}
	}

	public String unReserveBook(Transaction txn) {
		Book book=bookDb.checkAvailability(txn.getBookId());
		if(Objects.isNull(book)){
			return "Book is not available";
		}

		BookStatus status=book.getStatus();

		if(BookStatus.RESERVED==status) {
			if(bookDb.getTransaction(txn)!=null)
				return bookDb.doOperation(txn);
			else
				return "Book is reserved by some other user";
		}else if(BookStatus.AVAILABLE==status) {
			return "Book is already unreserved";
		}else {
			return "Book is already issued";
		}

	}

	public String issueBook(Transaction txn) {
		Book book=bookDb.checkAvailability(txn.getBookId());
		if(Objects.isNull(book)){
			return "Book is not available";
		}

		BookStatus status=book.getStatus();

		if(BookStatus.AVAILABLE==status) {
			return bookDb.doOperation(txn);
		}else if(BookStatus.RESERVED==status) {
			if(bookDb.getTransaction(txn)!=null)
				return bookDb.doOperation(txn);
			else
				return "Book is reserved by some other user";
		}else {
			return "Book is already issued";
		}
	}

	public String returnBook(Transaction txn) {
		Book book=bookDb.checkAvailability(txn.getBookId());
		if(Objects.isNull(book)){
			return "Book is not available";
		}

		BookStatus status=book.getStatus();

		if(BookStatus.ISSUED==status) {
			return bookDb.doOperation(txn);
		}else {
			return "Book is already available";
		}
	}
	
	public List<Book> getAllBooks(){
		return bookDb.getAllBooks();
	}
}
