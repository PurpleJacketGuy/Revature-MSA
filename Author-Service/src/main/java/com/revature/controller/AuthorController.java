package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Author;
import com.revature.repo.AuthorRepo;

@RestController
public class AuthorController {
	
	@Autowired
	AuthorRepo authorRepo;
	
	@GetMapping("/author")
	public List<Author> getAllAuthors(){
		return this.authorRepo.findAll();
	}
	
	@PostMapping("/find-author")
	public Author getAuthor(@RequestParam String name) {
		Author searchAuthor = new Author();
		try {
		searchAuthor = this.authorRepo.findByAuthor(name);
		} catch(Exception e) {
			e.printStackTrace();
			searchAuthor = null;
		}
		return searchAuthor;
	}

}
