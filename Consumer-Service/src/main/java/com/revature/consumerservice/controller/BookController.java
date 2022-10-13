package com.revature.consumerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.consumerservice.models.Book;
import com.revature.consumerservice.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/book")
	public List<Book> getBooks(){
		return this.bookService.getBooksFromOtherService();
	}
}
