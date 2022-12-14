package com.revature.consumerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.consumerservice.models.Author;
import com.revature.consumerservice.service.AuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping("/author")
	public List<Author> getAuthors(){
		return this.authorService.getAuthorsFromOtherService();
	}
	
	@PostMapping("/find-author")
	public Author getAuthor(@RequestParam String name) {
		return this.authorService.getAuthorFromOtherService(name);
	}

}
