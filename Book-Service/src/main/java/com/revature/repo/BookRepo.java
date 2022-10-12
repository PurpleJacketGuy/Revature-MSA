package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

}
