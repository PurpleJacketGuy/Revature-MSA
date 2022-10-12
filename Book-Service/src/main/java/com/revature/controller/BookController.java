package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Book;
import com.revature.repo.BookRepo;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	BookRepo bookRepo;
	
	@GetMapping("/book")
	public List<Book> getAllBooks(){
		return this.bookRepo.findAll();
	}
}
