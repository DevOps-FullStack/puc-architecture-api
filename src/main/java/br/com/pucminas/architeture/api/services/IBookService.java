package br.com.pucminas.architeture.api.services;

import java.util.List;

import br.com.pucminas.architeture.api.models.Author;
import br.com.pucminas.architeture.api.models.Book;
import br.com.pucminas.architeture.api.models.Review;

public interface IBookService extends IService<Book> {
	List<Book> findByNameOrYear(String name, int year);

	Author findAuthorById(int id, int idAuthor);

	boolean addAuthor(int id, int idAuthor);

	boolean deleteAuthor(int id, int idAuthor);

	Review findReviewByBook(int id, int idReview);

	Review newReview(int id, Review review);

	Review updateReviewByBook(int id, int idReview, Review review);

	boolean deleteReview(int id, int idReview);

	List<Book> findById(List<Integer> books);
}
