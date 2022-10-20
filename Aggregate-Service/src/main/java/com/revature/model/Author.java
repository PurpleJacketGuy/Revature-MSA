package com.revature.model;

import java.util.List;
import java.util.Objects;

public class Author {

	private int id;
	private String name;
	private List<Book> myBooks;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Book> getMyBooks() {
		return myBooks;
	}
	public void setMyBooks(List<Book> myBooks) {
		this.myBooks = myBooks;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, myBooks, name);
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
		return id == other.id && Objects.equals(myBooks, other.myBooks) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", myBooks=" + myBooks + "]";
	}
	
	
}
