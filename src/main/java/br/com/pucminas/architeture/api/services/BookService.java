package br.com.pucminas.architeture.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pucminas.architeture.api.models.Author;
import br.com.pucminas.architeture.api.models.Book;
import br.com.pucminas.architeture.api.models.Review;
import br.com.pucminas.architeture.api.repositories.IAuthorRepository;
import br.com.pucminas.architeture.api.repositories.IBookRepository;

@Service
public class BookService implements IBookService {

	@Autowired
	private IBookRepository repository;
	@Autowired
	private IAuthorRepository authorRepository;
	@Autowired
	private IReviewService reviewService;

	@Override
	public List<Book> findAll() {

		return repository.findAll();
	}

	@Override
	public Book findById(int id) {

		return repository.findById(id);
	}

	@Override
	public Book newModel(Book model) {
		return repository.newModel(model);
	}

	@Override
	public Book updateModel(int id, Book model) {

		if (repository.findById(id) == null)
			return null;
		model.setId(id);
		return repository.updateModel(model);
	}

	@Override
	public boolean deleteModel(int id) {
		return repository.deleteModel(id);
	}

	@Override
	public List<Book> findByNameOrYear(String name, int year) {
		// TODO Auto-generated method stub
		return repository.findAllByNameOrYear(name, year);
	}

	@Override
	public Author findAuthorById(int id, int idAuthor) {
		Book book = repository.findById(id);

		if (book == null)
			return null;
		Optional<Integer> idAuthorBook = book.getAuthors().stream().filter(a -> a == idAuthor).findFirst();

		if (!idAuthorBook.isPresent())
			return null;

		return authorRepository.findById(idAuthorBook.get());
	}

	@Override
	public boolean addAuthor(int id, int idAuthor) {

		Book book = repository.findById(id);

		if (book == null)
			return false;

		Author author = authorRepository.findById(idAuthor);

		if (author == null)
			return false;

		return repository.addAuthor(id, idAuthor);
	}

	@Override
	public boolean deleteAuthor(int id, int idAuthor) {

		Book book = repository.findById(id);

		if (book == null)
			return false;

		Author author = authorRepository.findById(idAuthor);

		if (author == null)
			return false;

		return repository.deleteAuthor(id, idAuthor);
	}

	@Override
	public Review findReviewByBook(int id, int idReview) {
		Book book = repository.findById(id);

		Optional<Integer> reviewId = book.getReviews().stream().filter(a -> a == idReview).findFirst();

		if (reviewId.isPresent())
			return reviewService.findById(reviewId.get());

		return null;
	}

	@Override
	public Review newReview(int id, Review review) {
		Book book = findById(id);

		if (book == null)
			return null;

		review.setIdBook(id);

		Review result = reviewService.newModel(review);
		book.addReview(result);
		updateModel(id, book);

		return review;
	}

	@Override
	public Review updateReviewByBook(int id, int idReview, Review review) {
		Book book = findById(id);

		if (book == null)
			return null;

		Optional<Integer> reviewId = book.getReviews().stream().filter(a -> a == idReview).findFirst();

		if (reviewId.isPresent())
			return reviewService.updateModel(idReview, review);

		return null;
	}

	@Override
	public boolean deleteReview(int id, int idReview) {
		Book book = findById(id);

		if (book == null)
			return false;

		Optional<Integer> reviewId = book.getReviews().stream().filter(a -> a == idReview).findFirst();

		if (reviewId.isPresent())
			return reviewService.deleteModel(idReview);

		return false;
	}

	@Override
	public List<Book> findById(List<Integer> books) {
		return repository.findAll().stream().filter(a -> books.contains(a.getId())).collect(Collectors.toList());
	}

}
