package br.com.pucminas.architeture.api.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ShoppingCart extends ModelBase {
	@JsonIgnore
	private List<Integer> books;
	private Order order;

	public ShoppingCart(int id, Order order) {
		super(id);
		this.order = order;
	}

	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}

	public ShoppingCart(int id) {
		super(id);
	}

	public List<Integer> getBooks() {
		return books;
	}

	public void setBooks(List<Integer> books) {
		this.books = books;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void addBook(Book book) {
		if (books == null)
			books = new ArrayList<Integer>();
		books.add(book.getId());
	}
}
