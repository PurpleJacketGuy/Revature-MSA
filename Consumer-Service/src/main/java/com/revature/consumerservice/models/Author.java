package com.revature.consumerservice.models;

import java.util.Objects;

public class Author {

	private int id;
	private String author;
	private int birthYear;
	private int deathYear;
	private int booksWritten;
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
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public int getDeathYear() {
		return deathYear;
	}
	public void setDeathYear(int deathYear) {
		this.deathYear = deathYear;
	}
	public int getBooksWritten() {
		return booksWritten;
	}
	public void setBooksWritten(int booksWritten) {
		this.booksWritten = booksWritten;
	}
	@Override
	public int hashCode() {
		return Objects.hash(author, birthYear, booksWritten, deathYear, id);
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
		return Objects.equals(author, other.author) && birthYear == other.birthYear
				&& booksWritten == other.booksWritten && deathYear == other.deathYear && id == other.id;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", author=" + author + ", birthYear=" + birthYear + ", deathYear=" + deathYear
				+ ", booksWritten=" + booksWritten + "]";
	}
	
	
}
