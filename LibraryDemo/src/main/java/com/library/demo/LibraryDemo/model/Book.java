package com.library.demo.LibraryDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	Integer bookId;
	String bookName;
	BookStatus status;
}
