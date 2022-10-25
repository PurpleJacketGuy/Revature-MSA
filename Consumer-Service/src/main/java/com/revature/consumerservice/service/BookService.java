package com.revature.consumerservice.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.consumerservice.models.Book;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class BookService {
	
	private final RestTemplate restTemplate; 
	
	public BookService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Retry(name="bookSearch", fallbackMethod="backupPlan")
	public List<Book> getBooksFromOtherService(){
		URI uri = URI.create("http://gateway:9000/book-api/api/book");
		
		Book[] allTheBooks = this.restTemplate.getForObject(uri, Book[].class);
		
		List<Book> bookList = Arrays.asList(allTheBooks);
		
		return bookList;
	}

	//Typically leads to a different service. Right now just hardcoded
	public List<Book> backupPlan(Exception e){
		List<Book> fakeBooks = new ArrayList<>();
		fakeBooks.add(new Book());
		return fakeBooks;
	}
}