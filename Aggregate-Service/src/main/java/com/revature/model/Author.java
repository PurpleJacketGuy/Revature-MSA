package com.revature.model;

import java.util.List;
import java.util.Objects;

public class Author {

	private int id;
	private String author;
	private List<Book> myBooks;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public List<Book> getMyBooks() {
		return myBooks;
	}
	public void setMyBooks(List<Book> myBooks) {
		this.myBooks = myBooks;
	}
	@Override
	public int hashCode() {
		return Objects.hash(author, id, myBooks);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(author, other.author) && id == other.id && Objects.equals(myBooks, other.myBooks);
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", author=" + author + ", myBooks=" + myBooks + "]";
	}
	
	
}
