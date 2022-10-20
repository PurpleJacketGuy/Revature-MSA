package com.revature.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Author;
import com.revature.model.Book;

@Service
public class AuthorService {
	
	private String endpoint = "http://localhost:9000/author-api/";
	
	private final RestTemplate restTemplate;
	
	private BookService bookService;
	
	public AuthorService(RestTemplate restTemplate, BookService bookService) {
		this.restTemplate = restTemplate;
		this.bookService = bookService;
	}
	
	public List<Author> getAuthorsFromOtherService(){
		URI uri = URI.create(endpoint + "author");
		
		Author[] allTheAuthors = this.restTemplate.getForObject(uri, Author[].class);
		
		List<Author> authorList = Arrays.asList(allTheAuthors);
		
		List<Book> bookList = bookService.getBooksFromOtherService();
		
		for(Author a: authorList) {
			List<Book> authorBookList = new ArrayList<>();
			for(Book b: bookList) {
				
				if(b.getAuthor().equals(a.getAuthor())) {
					authorBookList.add(b);
				}
			}
			a.setMyBooks(authorBookList);
		}
		return authorList;
	}

}
