package com.revature.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Book;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class BookService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String endpoint = "http://gateway:9000/book-api/";
	
	@Retry(name="bookSearch", fallbackMethod="bookBackup")
	public List<Book> getBooksFromOtherService(){
		URI uri = URI.create(endpoint + "api/book");
		
		Book[] allTheBooks = this.restTemplate.getForObject(uri, Book[].class);
		
		List<Book> bookList = Arrays.asList(allTheBooks);
		
		return bookList;
	}

	public List<Book> bookBackup(Exception e){
		List<Book> fakeBooks = new ArrayList<>();
		
		return fakeBooks;
	}
}
