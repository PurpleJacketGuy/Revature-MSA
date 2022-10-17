package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
	
	Author findByAuthor(String authorName);
}
