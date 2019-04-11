package br.com.pucminas.architeture.api.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ShoppingCart extends ModelBase {
	@JsonIgnore
	private List<Integer> books;
	private Order orders;

	public ShoppingCart(int id, LocalDateTime createdAt, LocalDateTime updatedAt, Order orders) {
		super(id);
		this.orders = orders;
	}

	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}

	public List<Integer> getBooks() {
		return books;
	}

	public void setBooks(List<Integer> books) {
		this.books = books;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	public void addBook(Book book) {
		if (books == null)
			books = new ArrayList<Integer>();
		books.add(book.getId());
	}
}
