package com.library.demo.LibraryDemo.model;

import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum BookStatus implements Serializable{
	AVAILABLE,RESERVED,ISSUED,UNAVAILABLE;
	
	@Override
	public String toString() {
		return this.toString();
	}
	
	@JsonCreator
	public BookStatus fromText(String text) {
		return Arrays.stream(BookStatus.values()).filter(e->e.toString().equalsIgnoreCase(text)).findFirst().get();
	}
}
