package com.revature.consumerservice.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.consumerservice.models.Author;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class AuthorService {

	private final RestTemplate restTemplate;
	
	public AuthorService (RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Retry(name="authorSearch", fallbackMethod="backupPlan")
	public List<Author> getAuthorsFromOtherService(){
		URI uri = URI.create("http://gateway:9000/author-api/author");
		
		Author[] allTheAuthors = this.restTemplate.getForObject(uri, Author[].class);
		
		List<Author> authorList = Arrays.asList(allTheAuthors);
		
		return authorList;
	}
	
	public List<Author> backupPlan(Exception e){
		List<Author> fakeAuthors = new ArrayList<>();
		fakeAuthors.add(new Author());
		return fakeAuthors;
	}
	
	public Author getAuthorFromOtherService(String name) {
		URI uri = URI.create("http://gateway:9000/author-api/find-author/?name=" +name);
		
		Author author= this.restTemplate.postForObject(uri, null, Author.class);
		
		return author;
	}
}
