package br.com.pucminas.architeture.api.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Book extends ModelBase {
	private String name;
	private int year;
	@JsonIgnore
	private List<Integer> authors;
	@JsonIgnore
	private List<Integer> reviews;

	public Book(int id, String name, int year) {
		super(id);
		this.name = name;
		this.year = year;
	}

	public Book() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Integer> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Integer> authors) {
		this.authors = authors;
	}

	public List<Integer> getReviews() {
		return reviews;
	}

	public void setReviews(List<Integer> reviews) {
		this.reviews = reviews;
	}

	public void addAuthor(Author author) {
		if (authors == null)
			authors = new ArrayList<Integer>();
		authors.add(author.getId());
	}

	public void addReview(Review review) {
		if (reviews == null)
			reviews = new ArrayList<Integer>();
		reviews.add(review.getId());
	}
}
