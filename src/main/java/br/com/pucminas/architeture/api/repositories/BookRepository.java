package br.com.pucminas.architeture.api.repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.pucminas.architeture.api.models.Book;

@Service
public class BookRepository implements IBookRepository {

	private static List<Book> books = new ArrayList<Book>();

	static {
		Book book1 = new Book(1, "Book 1", 2017, 10.00);
		book1.setAuthors(Arrays.asList(1));
		book1.setReviews(Arrays.asList(1));
		books.add(book1);

		Book book2 = new Book(2, "Book 2", 2017, 15.00);
		book1.setAuthors(Arrays.asList(2));
		book1.setReviews(Arrays.asList(2));
		books.add(book2);

		Book book3 = new Book(3, "Book 3", 2017, 20.00);
		book1.setAuthors(Arrays.asList(3));
		book1.setReviews(Arrays.asList(3));
		books.add(book3);
	}

	@Override
	public List<Book> findAllByNameOrYear(String name, int year) {

		return books.stream().filter(a -> a.getName().contains(name) || a.getYear() == year)
				.collect(Collectors.toList());
	}

	@Override
	public Book findById(int id) {
		Optional<Book> book = books.stream().filter(a -> a.getId() == id).findFirst();

		if (book.isPresent())
			return book.get();
		return null;
	}

	@Override
	public Book newModel(Book model) {
		Book book = new Book(books.size() + 1, model.getName(), model.getYear(), model.getPrice());
		book.setAuthors(model.getAuthors());
		book.setReviews(model.getReviews());
		books.add(book);
		return book;
	}

	@Override
	public Book updateModel(Book model) {
		ListIterator<Book> iterator = books.listIterator();
		Book response = null;
		while (iterator.hasNext()) {
			Book result = iterator.next();
			if (result.getId() == model.getId()) {
				iterator.set(model);
				response = model;
			}
		}
		return response;
	}

	@Override
	public boolean deleteModel(int id) {
		return books.removeIf(a -> a.getId() == id);
	}

	@Override
	public List<Book> findAll() {
		return books;
	}

	@Override
	public boolean addAuthor(int id, int idAuthor) {

		Optional<Book> book = books.stream().filter(a -> a.getId() == id).findFirst();

		if (!book.isPresent())
			return false;

		book.get().addAuthor(idAuthor);

		return true;
	}

	@Override
	public boolean deleteAuthor(int id, int idAuthor) {

		Book book = books.stream().filter(a -> a.getId() == id).findFirst().get();

		return book.getAuthors().removeIf(a -> a == idAuthor);
	}

}
