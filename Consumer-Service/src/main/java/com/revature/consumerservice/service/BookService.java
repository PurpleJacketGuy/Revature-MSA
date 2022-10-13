package com.revature.consumerservice.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.consumerservice.models.Book;

@Service
public class BookService {
	
	private final RestTemplate restTemplate; 
	
	public BookService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public List<Book> getBooksFromOtherService(){
		URI uri = URI.create("http://localhost:8000/api/book");
		
		Book[] allTheBooks = this.restTemplate.getForObject(uri, Book[].class);
		
		List<Book> bookList = Arrays.asList(allTheBooks);
		
		return bookList;
	}

}