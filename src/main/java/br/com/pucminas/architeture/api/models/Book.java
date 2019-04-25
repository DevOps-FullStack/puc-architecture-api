package br.com.pucminas.architeture.api.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Book extends ModelBase {
	private String name;
	private int year;
	private double price;
	@JsonIgnore
	private List<Integer> authors;
	@JsonIgnore
	private List<Integer> reviews;

	public Book(int id, String name, int year, double price) {
		super(id);
		this.name = name;
		this.year = year;
		this.price = price;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public void addAuthor(int id) {
		if (authors == null)
			authors = new ArrayList<Integer>();
		authors.add(id);
	}

	public void addReview(Review review) {
		if (reviews == null)
			reviews = new ArrayList<Integer>();
		reviews.add(review.getId());
	}
}
