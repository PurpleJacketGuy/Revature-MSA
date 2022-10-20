package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Author;
import com.revature.service.AuthorService;

@RestController
public class AuthorAndBookController {

	@Autowired
	AuthorService authorService;
	
	@GetMapping("/authors")
	public List<Author> getAuthors(){
		return this.authorService.getAuthorsFromOtherService();
	}
}
